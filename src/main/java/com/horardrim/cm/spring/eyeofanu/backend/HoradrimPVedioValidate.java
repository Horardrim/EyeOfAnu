package com.horardrim.cm.spring.eyeofanu.backend;

import com.horardrim.cm.spring.eyeofanu.model.issue.HoradrimIssue;
import com.horardrim.cm.spring.eyeofanu.model.issue.HoradrimIssueCategory;
import com.horardrim.cm.spring.eyeofanu.model.issue.HoradrimIssueState;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HoradrimPVedioValidate extends HoradrimESValidate {

    private boolean validateStatus = false;

    private List<HoradrimIssue> issues = new ArrayList<HoradrimIssue>();

    @Override
    protected String [] fetchRelatedIndices(final RestHighLevelClient client) throws IOException {
        GetIndexResponse indicesResponse =  client.indices()
          .get(new GetIndexRequest("porn-vedio-*"),  RequestOptions.DEFAULT);

        logger.info("porn vedio index length {}", indicesResponse.getIndices().length);
        return indicesResponse.getIndices();
    }

    @Override
    protected void validate(final RestHighLevelClient client, final String indicesName) throws IOException {
        validateStatus = true;
        SearchRequest searchRequest = new SearchRequest(indicesName);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(sourceBuilder).scroll(TimeValue.timeValueMinutes(10L));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        long matchedDocCount = searchResponse.getHits().getHits().length;

        for(SearchHit hit : searchResponse.getHits().getHits()) {
            validateBango(hit.getIndex(), hit.getId(), hit.getSourceAsMap().get("bango").toString());
        }

        while(matchedDocCount < searchResponse.getHits().getTotalHits().value) {
            SearchScrollRequest scrollRequest = new SearchScrollRequest(searchResponse.getScrollId());
            scrollRequest.scroll(TimeValue.timeValueMinutes(10L));
            searchResponse = client.searchScroll(scrollRequest, RequestOptions.DEFAULT);
            matchedDocCount += searchResponse.getHits().getHits().length;
            
            for(SearchHit hit : searchResponse.getHits().getHits()) {
                validateBango(hit.getIndex(), hit.getId(), hit.getSourceAsMap().get("bango").toString());
            }   
        }
        
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest(); 
        clearScrollRequest.addScrollId(searchResponse.getScrollId());
        ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
        validateStatus = false;
    }

    private void validateBango(final String indices, final String id, final String bango) {
        String combinedBango = indices.split("-")[2].toUpperCase() + id;
        if (!combinedBango.equals(bango)) {
            issues.add(new HoradrimIssue(HoradrimIssueCategory.BANGO_ISSUE,
                indices, id, String.format("bango(%s) and index(%s/%s) is not consistent", bango, indices, id),
                System.currentTimeMillis(), HoradrimIssueState.NEW));
        }
    }

    public List<HoradrimIssue> getVedioIssues() {
        return issues;
    }
}
