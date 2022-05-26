package com.itt.IssueTrackingTool.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import com.itt.IssueTrackingTool.exception.IssueNotFoundException;
import com.itt.IssueTrackingTool.model.Issue;
import com.itt.IssueTrackingTool.repo.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/api")
@ResponseBody
public class IssueController {
    @Autowired
    IssueRepository issueRepository;
    @GetMapping("/Issue")
    public ResponseEntity<List<Issue>> getAllIssues() {
        return new ResponseEntity<>(issueRepository.findAll(), HttpStatus.CREATED);
    }
    @PostMapping("/Issue")
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
        Issue _issue = issueRepository.save(new Issue(issue.getTitle(), issue.getDescription(), issue.getCreationDate(), issue.getStatus(), issue.getPriorityLevel()));
        return new ResponseEntity<>(_issue, HttpStatus.CREATED);
    }
    @PutMapping("/Issue/{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable("id") long id, @RequestBody Issue issue) {
        Issue _issue = issueRepository.findById(id)
                .orElseThrow(() -> new IssueNotFoundException("Not found Tutorial with id = " + id));
        _issue.setTitle(issue.getTitle());
        _issue.setDescription(issue.getDescription());
        _issue.setClosingDate(issue.getClosingDate());
        _issue.setStatus(issue.getStatus());
        _issue.setPriorityLevel(issue.getPriorityLevel());
        return new ResponseEntity<>(issueRepository.save(_issue), HttpStatus.OK);
    }
}