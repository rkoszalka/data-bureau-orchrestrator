package org.koszalka.data.bureau.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * REST Template Singleton Configuration
 * @author rkoszalka
 */
@Configuration
public class RestTemplateClient {

    /**
     * Return a RestTemplate() Singleton to all facades
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
