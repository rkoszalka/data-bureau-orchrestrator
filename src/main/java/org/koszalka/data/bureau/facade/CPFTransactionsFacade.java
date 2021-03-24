package org.koszalka.data.bureau.facade;

import org.koszalka.data.bureau.config.RestTemplateClient;
import org.koszalka.data.bureau.kafka.event.TransactionEvent;
import org.koszalka.data.bureau.kafka.producer.TransactionProducer;
import org.koszalka.data.bureau.presentation.dto.TransactionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * CPF Transactions Facade
 * @author rkoszalka
 */
@Service
public class CPFTransactionsFacade {

    private final TransactionProducer transactionProducer;

    @Autowired
    public CPFTransactionsFacade(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    /**
     * Get CPF Transactions from Nano-Service
     * @param event TransactionEvent
     */
    public ResponseEntity<TransactionsDTO> getTransactions(TransactionEvent event) {
        transactionProducer.send(event);
    }

}
