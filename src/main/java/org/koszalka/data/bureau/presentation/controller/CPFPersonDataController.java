package org.koszalka.data.bureau.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.data.bureau.facade.CPFCreditScoreFacade;
import org.koszalka.data.bureau.facade.CPFPersonDataFacade;
import org.koszalka.data.bureau.presentation.api.CPFCreditScoreAPI;
import org.koszalka.data.bureau.presentation.api.CPFPersonDataAPI;
import org.koszalka.data.bureau.presentation.dto.CreditScoreDTO;
import org.koszalka.data.bureau.presentation.dto.PersonDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * CPF Person Data controller
 * @author rkoszalka
 */
@Slf4j
@RestController
public class CPFPersonDataController implements CPFPersonDataAPI {

    private final CPFPersonDataFacade cpfPersonDataFacade;

    @Autowired
    public CPFPersonDataController(CPFPersonDataFacade cpfPersonDataFacade) {
        this.cpfPersonDataFacade = cpfPersonDataFacade;
    }

    /**
     * @param cpfNumber CPF Number
     * @return personDataDTO.
     */
    @Override
    public ResponseEntity<PersonDataDTO> getPersonData(@RequestParam String cpfNumber) {
        if (!StringUtils.hasText(cpfNumber)) {
            log.error("M=getCPFCreditScore, message=CPF number is required");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            ResponseEntity<PersonDataDTO> response = cpfPersonDataFacade.getPersonData(cpfNumber);
            if (Objects.isNull(response)) {
                log.error("M=.getCPFCreditScore, message=Person Data not found for {}", cpfNumber);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (InternalError e) {
            log.error("M=getPersonData, message=Internal Server Error. {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
