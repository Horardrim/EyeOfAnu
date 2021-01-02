package com.horardrim.cm.spring.eyeofanu.autoconfig;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration()
@EnableConfigurationProperties(HoradrimESProperties.class)
public class HoradrimESAutoConfiguration {

    @Autowired
    private HoradrimESProperties properties;

    public List<String> peers() {
        return properties.getPeers();
    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        List<HttpHost> esHttpPeers = properties.getPeers().stream()
            .map(peers -> {
                String [] esHttpPeerDef = peers.split(":");
                String esHttpIp = esHttpPeerDef[0];
                String esHttpPort = esHttpPeerDef[1];
                return new HttpHost(esHttpIp, Integer.parseUnsignedInt(esHttpPort));
            })
            .collect(Collectors.toList());

        RestClientBuilder esClientBuilder = RestClient.builder(esHttpPeers.toArray(new HttpHost[esHttpPeers.size()]));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(esClientBuilder);
        return restHighLevelClient;
    }
}
