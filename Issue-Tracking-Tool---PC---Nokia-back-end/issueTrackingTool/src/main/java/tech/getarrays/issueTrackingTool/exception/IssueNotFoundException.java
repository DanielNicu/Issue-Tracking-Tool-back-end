package tech.getarrays.issueTrackingTool.exception;

public class IssueNotFoundException extends  RuntimeException {
    public IssueNotFoundException(String message) {
        super(message);
    }
}