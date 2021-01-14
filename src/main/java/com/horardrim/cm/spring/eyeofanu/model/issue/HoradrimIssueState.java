package com.horardrim.cm.spring.eyeofanu.model.issue;

public enum HoradrimIssueState {
    NEW(0),
    SOLVED(1);
    
    private int stateVal;

    HoradrimIssueState(final int stateVal) {
        this.stateVal = stateVal;
    }
}
