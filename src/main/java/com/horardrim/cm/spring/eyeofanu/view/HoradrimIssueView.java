package com.horardrim.cm.spring.eyeofanu.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoradrimIssueView {
    private String issueCategory;
    private String index;
    private String indexId;
    private String description;
    private long timestamp;
    private String issueState;
}
