package com.clienteservice;

import com.clienteservice.config.DocumentedApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteServiceApplication implements DocumentedApi {
        public static void main(String[] args) {
            SpringApplication.run(ClienteServiceApplication.class, args);
        }
}


