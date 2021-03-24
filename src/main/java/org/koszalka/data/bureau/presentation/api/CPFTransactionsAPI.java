package org.koszalka.data.bureau.presentation.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.koszalka.data.bureau.presentation.dto.CreditScoreDTO;
import org.koszalka.data.bureau.presentation.dto.TransactionsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CPF Transactions mapping declaration
 * @author rkoszalka
 */

@Api(value = "CPFTransactionsAPI")
@RequestMapping("/v1/cpf/transactions/{cpfNumber}")
public interface CPFTransactionsAPI {

    /**
     * Mapping for CPF Transactions endpoint
     * @param cpfNumber CPF Number
     */
    @ApiOperation(value = "Search transactions for requested CPF", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Credit Score delivered"),
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 500, message = "Server error.")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<TransactionsDTO> getCPFTransactions(@RequestParam String cpfNumber, @RequestParam String searchType,
                                                       @RequestParam String transactionValue);


}
