package org.koszalka.data.bureau.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.data.bureau.kafka.constants.EventConstants;
import org.koszalka.data.bureau.kafka.event.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Slf4j
public class TransactionProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TransactionProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(TransactionEvent message){
        log.info("M=send, message={} to topic={}", message, EventConstants.TRANSACTION_TOPIC);
        kafkaTemplate.send(EventConstants.TRANSACTION_TOPIC, message);
    }
}
