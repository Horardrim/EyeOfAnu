package com.horardrim.cm.spring.eyeofanu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

    // @Bean
    // public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    // {
    //     return args -> {

    //         logger.info("Let's inspect the beans provided by Spring Boot:");

    //         String[] beanNames = ctx.getBeanDefinitionNames();
    //         Arrays.sort(beanNames);
    //         for (String beanName : beanNames) {
    //             logger.info(beanName);
    //         }
    //     };
    // }
}
