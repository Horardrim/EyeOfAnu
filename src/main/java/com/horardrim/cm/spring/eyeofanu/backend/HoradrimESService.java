package com.horardrim.cm.spring.eyeofanu.backend;

import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;

import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HoradrimESService {

    @Autowired
    private HoradrimPVedioValidate vedioValidator;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    // @Scheduled(fixedRate = 10000)
    public void validate() throws IOException {
        vedioValidator.validateData(restHighLevelClient);
    }

    // @PostConstruct
    // public void backendUp() throws IOException {
    //     vedioValidator.validateData(restHighLevelClient);
    // }

    @PreDestroy
    public void backendDown() throws IOException {
        logger.info("BACKEND DOWN");
        restHighLevelClient.close();
    }
}
