package tech.getarrays.issueTrackingTool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.issueTrackingTool.exception.ActionPointNotFoundException;
import tech.getarrays.issueTrackingTool.model.ActionPoint;
import tech.getarrays.issueTrackingTool.repo.ActionPointRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ActionPointService {
    private final ActionPointRepo ActionPointRepo;

    @Autowired
    public ActionPointService(ActionPointRepo ActionPointRepo) {
        this.ActionPointRepo = ActionPointRepo;
    }

    public ActionPoint addActionPoint(ActionPoint ActionPoint) {
        ActionPoint.setActionPointId(Integer.parseInt(UUID.randomUUID().toString()));
        return ActionPointRepo.save(ActionPoint);
    }

    public List<ActionPoint> findAllActionPoints() {
        return ActionPointRepo.findAll();
    }

    public ActionPoint updateActionPoint(ActionPoint ActionPoint) {
        return ActionPointRepo.save(ActionPoint);
    }

    public ActionPoint findActionPointById(Long id) {
        return ActionPointRepo.findActionPointById(id)
                .orElseThrow(() -> new ActionPointNotFoundException("Action point by id " + id + " was not found"));
    }

    public void deleteActionPoint(Long id){
        ActionPointRepo.deleteActionPointById(id);
    }
}
