package org.koszalka.data.bureau.presentation.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.koszalka.data.bureau.presentation.dto.CreditScoreDTO;
import org.koszalka.data.bureau.presentation.dto.PersonDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CPF Person Data mapping declaration
 * @author rkoszalka
 */
@Api(value = "CPFPersonDataAPI")
@RequestMapping("/v1/cpf/person-data/{cpfNumber}")
public interface CPFPersonDataAPI {

    /**
     * Mapping for CPF Credit Score endpoint
     * @param cpfNumber CPF Number
     */
    @ApiOperation(value = "Person Data for requested CPF", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person Data delivered"),
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 500, message = "Server error.")
    })
    @GetMapping(produces = "application/json")
    ResponseEntity<PersonDataDTO> getPersonData(@PathVariable String cpfNumber);


}
