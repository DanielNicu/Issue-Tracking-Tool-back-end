package com.itt.IssueTrackingTool.exception;

public class IssueNotFoundException extends  RuntimeException {
    public IssueNotFoundException(String message) {
        super(message);
    }
}
