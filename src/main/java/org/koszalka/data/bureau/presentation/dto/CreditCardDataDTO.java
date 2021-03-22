package org.koszalka.data.bureau.presentation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * CPF Credit Card data DTO
 * @author rkoszalka
 */
@Getter
@Setter
public class CreditCardDataDTO {

    public String lastTransaction;
    public Integer creditCardNumber;

}
