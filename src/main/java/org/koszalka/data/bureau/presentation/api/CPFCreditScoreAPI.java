package org.koszalka.data.bureau.presentation.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.koszalka.data.bureau.presentation.dto.CreditScoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CPF Credit Score mapping declaration
 * @author rkoszalka
 */

@Api(value = "CPFCreditScoreAPI")
@RequestMapping("/v1/cpf/credit-score/{cpfNumber}")
public interface CPFCreditScoreAPI {

    /**
     * Mapping for CPF Credit Score endpoint
     * @param cpfNumber CPF Number
     */
    @ApiOperation(value = "Search credit rating for requested CPF", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Credit Score delivered"),
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 500, message = "Server error.")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<CreditScoreDTO> getCPFCreditScore(@PathVariable String cpfNumber);


}
