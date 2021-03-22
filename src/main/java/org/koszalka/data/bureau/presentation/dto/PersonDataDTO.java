package org.koszalka.data.bureau.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Person Data DTO
 * @author rkoszalka
 */
@Getter
@Setter
public class PersonDataDTO {

    public String cpf;
    public String name;
    public AddressDTO address;
    public List<DebtsDTO> debts;

}
