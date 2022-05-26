package tech.getarrays.issueTrackingTool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.issueTrackingTool.model.ActionPoint;

import java.util.Optional;

public interface ActionPointRepo extends JpaRepository<ActionPoint, Long> {
    void deleteActionPointById(Long id);
    Optional<ActionPoint> findActionPointById(Long id);
}