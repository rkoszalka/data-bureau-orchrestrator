package org.koszalka.data.bureau.facade;

import org.koszalka.data.bureau.config.RestTemplateClient;
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

    @Value(value = "${data.bureau.transactions}")
    private String transactionsDNS;
    private final RestTemplateClient restTemplateClient;

    @Autowired
    public CPFTransactionsFacade(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    /**
     * Get CPF Transactions from Nano-Service
     * @param cpfNumber CPF Number
     */
    public ResponseEntity<TransactionsDTO> getTransactions(String cpfNumber) {
        RestTemplate restTemplate = restTemplateClient.restTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(transactionsDNS + "/" + cpfNumber, HttpMethod.GET, httpEntity, TransactionsDTO.class);
    }

}
