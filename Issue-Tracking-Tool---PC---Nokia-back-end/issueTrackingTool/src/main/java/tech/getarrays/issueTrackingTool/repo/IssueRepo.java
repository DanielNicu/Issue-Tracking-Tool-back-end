package tech.getarrays.issueTrackingTool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.issueTrackingTool.model.Issue;

import java.util.Optional;

public interface IssueRepo extends JpaRepository<Issue, Long> {
    void deleteIssueById(Long id);
    Optional<Issue> findIssueById(Long id);
}
