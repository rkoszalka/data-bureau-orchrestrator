package org.koszalka.data.bureau.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Financial Transaction DTO
 * @author rkoszalka
 */
@Getter
@Setter
public class FinancialTransactionDTO {

    public LocalDateTime transactionDate;
    public Float transactionValue;

}
