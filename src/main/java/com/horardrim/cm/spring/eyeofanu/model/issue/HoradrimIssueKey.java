package com.horardrim.cm.spring.eyeofanu.model.issue;

import java.io.Serializable;

import lombok.Data;

@Data
public class HoradrimIssueKey implements Serializable {

    private static final long serialVersionUID = 6811601262303871530L;

    private String vedioIndex;

    private String docId;

    private HoradrimIssueCategory category;

    private String validatingSession;

    @Override
    public boolean equals(Object o) {
        if (o instanceof HoradrimIssueKey) {
            HoradrimIssueKey key = (HoradrimIssueKey)o;
            return (key.vedioIndex == this.vedioIndex &&
                key.docId == this.docId &&
                key.category == this.category &&
                key.validatingSession == this.validatingSession);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result + (vedioIndex == null ? 0 : vedioIndex.hashCode());
        result = result + (docId == null ? 0 : docId.hashCode());
        result = result + (category == null ? 0 : category.name().hashCode());
        result = result + (validatingSession == null ? 0 : validatingSession.hashCode());

        return result;
    }
    
}
