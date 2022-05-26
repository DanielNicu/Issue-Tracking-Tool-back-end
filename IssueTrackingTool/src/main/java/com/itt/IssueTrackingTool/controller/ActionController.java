package com.itt.IssueTrackingTool.controller;

import java.util.ArrayList;
import java.util.List;

import com.itt.IssueTrackingTool.exception.ActionPointNotFoundException;
import com.itt.IssueTrackingTool.exception.IssueNotFoundException;
import com.itt.IssueTrackingTool.model.ActionPoint;
import com.itt.IssueTrackingTool.model.Issue;
import com.itt.IssueTrackingTool.repo.ActionRepository;
import com.itt.IssueTrackingTool.repo.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/api")
public class ActionController {
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private IssueRepository issueRepository;
    @GetMapping("/Issue/{issueid}/ActionPoint")
    public ResponseEntity<List<ActionPoint>> getAllCommentsByTutorialId(@PathVariable(value = "issueid") long issueid){
        return new ResponseEntity<>(actionRepository.findByIssueId(issueid), HttpStatus.OK);
    }
    @PostMapping("/Issue/{issueId}/ActionPoint")
    public ResponseEntity<ActionPoint> createAction(@PathVariable(value = "issueId") Long issueId,
                                                 @RequestBody ActionPoint actionRequest) {
        ActionPoint action = issueRepository.findById(issueId).map(issue -> {
            ActionPoint _issue = new ActionPoint(actionRequest.getTitle(), actionRequest.getDescription(), actionRequest.getStatus());
            _issue.setIssue(issue);
            return actionRepository.save(_issue);
        }).orElseThrow(() -> new ActionPointNotFoundException("Not found Tutorial with id = " + issueId));
        return new ResponseEntity<>(action, HttpStatus.CREATED);
    }
    @PutMapping("/ActionPoint/{id}")
    public ResponseEntity<ActionPoint> updateAction(@PathVariable("id") long id, @RequestBody ActionPoint actionRequest) {
        ActionPoint action = actionRepository.findById(id)
                .orElseThrow(() -> new ActionPointNotFoundException("CommentId " + id + "not found"));
        action.setDescription(actionRequest.getDescription());
        action.setStatus(actionRequest.getStatus());
        action.setTitle(actionRequest.getTitle());
        return new ResponseEntity<>(actionRepository.save(action), HttpStatus.OK);
    }
    @DeleteMapping("/ActionPoint/{id}")
    public ResponseEntity<HttpStatus> deleteAction(@PathVariable("id") long id) {
        actionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}