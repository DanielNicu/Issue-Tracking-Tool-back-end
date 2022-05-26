package com.itt.IssueTrackingTool.repo;


import com.itt.IssueTrackingTool.model.ActionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<ActionPoint, Long> {
    List<ActionPoint> findByIssueId(long type);
}