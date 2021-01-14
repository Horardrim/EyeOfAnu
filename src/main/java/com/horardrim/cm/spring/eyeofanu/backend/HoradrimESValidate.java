package com.horardrim.cm.spring.eyeofanu.backend;

import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public abstract class HoradrimESValidate {

    public void validateData(final RestHighLevelClient client) throws IOException {
        String [] relatedIndices = fetchRelatedIndices(client);
        for(String indices : relatedIndices) {
            validate(client, indices);
        }
    }

    protected abstract String [] fetchRelatedIndices(final RestHighLevelClient client) throws IOException;

    protected abstract void validate(final RestHighLevelClient client, final String indicesName) throws IOException;
}
