package com.lnp.restapi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LnpConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();

}
}
