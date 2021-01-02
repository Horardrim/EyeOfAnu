package com.horardrim.cm.spring.eyeofanu.backend;

import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
// import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private RestHighLevelClient restHighLevelClient;

    private void fetchAllIndex() {
        //  GetIndexRequest indexRequest = new GetIndexRequest("porn-vedio-*");
        // // indexRequest.id(622);
        // Map<String, Object> jsonMap = new HashMap<>();
        // jsonMap.put("aaaa", "bbbb");
        // jsonMap.put("aaaaaa", "cccc");
        // IndexRequest idxRequest = new IndexRequest("fake-vedio-bf", "_doc", "622").source(jsonMap);

        // try {
        //     // GetIndexResponse indexResponse =  restHighLevelClient.indices().get(indexRequest, RequestOptions.DEFAULT);
        //     // String[] indices = indexResponse.getIndices();
        //     restHighLevelClient.index(idxRequest, RequestOptions.DEFAULT);
        // } catch (IOException e) {
        //     logger.warn(e.toString());
        // }
    }

    @PreDestroy
    public void backendDown() throws IOException {
        logger.info("BACKEND DOWN");
        restHighLevelClient.close();
    }
}
