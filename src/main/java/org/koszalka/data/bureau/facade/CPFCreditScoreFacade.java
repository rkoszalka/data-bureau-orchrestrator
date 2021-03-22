package org.koszalka.data.bureau.facade;

import org.koszalka.data.bureau.config.RestTemplateClient;
import org.koszalka.data.bureau.presentation.dto.CreditScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * CPF Credit Score Facade
 * @author rkoszalka
 */
@Component
public class CPFCreditScoreFacade {

    @Value(value = "${data.bureau.credit}")
    private String creditScoreDNS;
    private final RestTemplateClient restTemplateClient;

    @Autowired
    public CPFCreditScoreFacade(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    /**
     * Get CPF Transactions from Nano-Service
     * @param cpfNumber CPF Number
     */
    public ResponseEntity<CreditScoreDTO> getCreditScore(String cpfNumber) {
        RestTemplate restTemplate = restTemplateClient.restTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(creditScoreDNS + "/" + cpfNumber, HttpMethod.GET, httpEntity, CreditScoreDTO.class);
    }
}
