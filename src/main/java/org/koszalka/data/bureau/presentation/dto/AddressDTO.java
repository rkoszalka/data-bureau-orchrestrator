package org.koszalka.data.bureau.presentation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Address DTO
 * @author rkoszalka
 */
@Getter
@Setter
public class AddressDTO {

    private String addressStreet;
    private String addressNumber;
    public String addressComplement;

}
