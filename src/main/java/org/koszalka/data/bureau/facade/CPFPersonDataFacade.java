package org.koszalka.data.bureau.facade;

import org.koszalka.data.bureau.config.RestTemplateClient;
import org.koszalka.data.bureau.presentation.dto.PersonDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * CPF Person Data Facade
 * @author rkoszalka
 */
@Component
public class CPFPersonDataFacade {

    @Value(value = "${data.bureau.data.bureau.person-data}")
    private String personDataDNS;

    private final RestTemplateClient restTemplateClient;

    @Autowired
    public CPFPersonDataFacade(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    /**
     * Get PersonData from Nano-Service
     * @param cpfNumber CPF Number
     */
    public ResponseEntity<PersonDataDTO> getPersonData(String cpfNumber) {
        RestTemplate restTemplate = restTemplateClient.restTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(personDataDNS + "/" + cpfNumber, HttpMethod.GET, httpEntity, PersonDataDTO.class);
    }

}
