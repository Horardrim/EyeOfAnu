package com.horardrim.cm.spring.eyeofanu.model.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@Entity
@IdClass(HoradrimIssueKey.class)
@Table(name = "hm_porn_vedio_issue")
public class HoradrimIssue implements Serializable {

    @Id
    @Column(name = "ISSUE_INDEX")
    private String vedioIndex;

    @Id
    @Column(name = "ISSUE_INDEX_DOC_ID")
    private String docId;

    @Id
    @Column(name = "ISSUE_CATEGORY")
    @Enumerated(EnumType.STRING)
    private HoradrimIssueCategory category;

    @Column(name = "ISSUE_DESCRIPTION")
    private String description;

    @Column(name = "ISSUE_REPORT_TIME")
    private Long reportTime;

    @Column(name = "ISSUE_STATE")
    @Enumerated(EnumType.STRING)
    private HoradrimIssueState state;

    @Id
    @Column(name = "VALIDATING_SESSION")
    private String validatingSession;

    public HoradrimIssue() {

    }
}
