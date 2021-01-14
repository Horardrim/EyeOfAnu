package com.horardrim.cm.spring.eyeofanu.model.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoradrimIssue {
    private HoradrimIssueCategory issueCategory;
    private String index;
    private String indexId;
    private String description;
    private long timestamp;
    private HoradrimIssueState issueState;
}
