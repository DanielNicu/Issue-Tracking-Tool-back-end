package com.itt.IssueTrackingTool.repo;

import java.awt.print.Pageable;
import java.util.List;

import com.itt.IssueTrackingTool.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {


}
