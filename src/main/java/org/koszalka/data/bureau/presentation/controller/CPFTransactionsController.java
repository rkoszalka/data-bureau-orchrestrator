package org.koszalka.data.bureau.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.data.bureau.facade.CPFTransactionsFacade;
import org.koszalka.data.bureau.presentation.api.CPFTransactionsAPI;
import org.koszalka.data.bureau.presentation.dto.TransactionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * CPF Transactions Controller
 * @author rkoszalka
 */
@Slf4j
@RestController
public class CPFTransactionsController implements CPFTransactionsAPI {

    private final CPFTransactionsFacade cpfTransactionsFacade;

    @Autowired
    public CPFTransactionsController(CPFTransactionsFacade cpfTransactionsFacade) {
        this.cpfTransactionsFacade = cpfTransactionsFacade;
    }

    /**
     * @param cpfNumber CPF Number
     * @return creditScoreDTO.
     */
    @Override
    public ResponseEntity<TransactionsDTO> getCPFTransactions(@RequestParam String cpfNumber) {
        if (!StringUtils.hasText(cpfNumber)) {
            log.error("M=getCPFCreditScore, message=CPF number is required");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            ResponseEntity<TransactionsDTO> response = cpfTransactionsFacade.getTransactions(cpfNumber);
            if (Objects.isNull(response)) {
                log.error("M=.getCPFCreditScore, message=Credit score not found for {}", cpfNumber);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (InternalError e) {
            log.error("M=getCPFCreditScore, message=Internal Server Error. {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
