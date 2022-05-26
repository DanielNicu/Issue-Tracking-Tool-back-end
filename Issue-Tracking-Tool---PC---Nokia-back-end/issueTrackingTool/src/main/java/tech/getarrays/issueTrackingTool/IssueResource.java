package tech.getarrays.issueTrackingTool;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.issueTrackingTool.model.Issue;
import tech.getarrays.issueTrackingTool.service.IssueService;

import java.util.List;

@RestController
@RequestMapping("/Issue")
public class IssueResource {
    private final IssueService IssueService;

    public IssueResource(IssueService IssueService) {
        this.IssueService = IssueService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues () {
        List<Issue> Issues = IssueService.findAllIssue();
        return new ResponseEntity<>(Issues, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Issue> getIssueById (@PathVariable("id") Long id) {
        Issue Issue = IssueService.findIssueById(id);
        return new ResponseEntity<>(Issue, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Issue> addIssue(@RequestBody Issue Issue) {
        Issue newIssue = IssueService.addIssue(Issue);
        return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue Issue) {
        Issue updateIssue = IssueService.updateIssue(Issue);
        return new ResponseEntity<>(updateIssue, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable("id") Long id) {
        IssueService.deleteIssue(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}