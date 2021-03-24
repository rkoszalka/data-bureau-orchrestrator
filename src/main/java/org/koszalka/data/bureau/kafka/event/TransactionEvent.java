package org.koszalka.data.bureau.kafka.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
public class TransactionEvent {

    public String cpfNumber;
    public String searchType;
    public String transactionValue;

}
