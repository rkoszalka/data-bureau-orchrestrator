package org.koszalka.data.bureau.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Credit Score DTO
 * @author rkoszalka
 */
@Getter
@Setter
public class CreditScoreDTO {

    public Integer age;
    public List<CPFPropertiesDTO> properties;
    public AddressDTO address;
    public String incomingType;

}
