package com.lnp.restapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // used 
public class SpringBootRestApiApplication {

    private static final Logger logger = LogManager.getLogger(SpringBootRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
        logger.info("SpringBootRestApiApplication has started.");
    }
}
