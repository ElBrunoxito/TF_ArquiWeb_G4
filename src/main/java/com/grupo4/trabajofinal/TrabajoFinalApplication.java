package com.grupo4.trabajofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration .class})
public class TrabajoFinalApplication {

    public static void main(String[] args) {SpringApplication.run(TrabajoFinalApplication.class, args);}

}
