package tech.getarrays.issueTrackingTool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.issueTrackingTool.exception.IssueNotFoundException;
import tech.getarrays.issueTrackingTool.model.Issue;
import tech.getarrays.issueTrackingTool.repo.IssueRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class IssueService {
    private final IssueRepo issueRepo;

    @Autowired
    public IssueService(IssueRepo issueRepo) {
        this.issueRepo = issueRepo;
    }

    public Issue addIssue(Issue issue) {
        issue.setId(Integer.parseInt(UUID.randomUUID().toString()));
        return issueRepo.save(issue);
    }

    public List<Issue> findAllIssue() {
        return issueRepo.findAll();
    }

    public Issue updateIssue(Issue issue) {
        return issueRepo.save(issue);
    }

    public Issue findIssueById(Long id) {
        return issueRepo.findIssueById(id)
                .orElseThrow(() -> new IssueNotFoundException("issue by id " + id + " was not found"));
    }

    public void deleteIssue(Long id){
        issueRepo.deleteIssueById(id);
    }
}