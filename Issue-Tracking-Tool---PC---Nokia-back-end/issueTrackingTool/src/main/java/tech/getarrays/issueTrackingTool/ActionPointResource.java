package tech.getarrays.issueTrackingTool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.issueTrackingTool.model.ActionPoint;
import tech.getarrays.issueTrackingTool.service.ActionPointService;

import java.util.List;

@RestController
@RequestMapping("/ActionPoint")
public class ActionPointResource {
    private final ActionPointService ActionPointService;

    public ActionPointResource(ActionPointService ActionPointService) {
        this.ActionPointService = ActionPointService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ActionPoint>> getAllActionPoints () {
        List<ActionPoint> ActionPoints = ActionPointService.findAllActionPoints();
        return new ResponseEntity<>(ActionPoints, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ActionPoint> getActionPointById (@PathVariable("id") Long id) {
        ActionPoint ActionPoint = ActionPointService.findActionPointById(id);
        return new ResponseEntity<>(ActionPoint, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ActionPoint> addActionPoint(@RequestBody ActionPoint ActionPoint) {
        ActionPoint newActionPoint = ActionPointService.addActionPoint(ActionPoint);
        return new ResponseEntity<>(newActionPoint, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ActionPoint> updateActionPoint(@RequestBody ActionPoint ActionPoint) {
        ActionPoint updateActionPoint = ActionPointService.updateActionPoint(ActionPoint);
        return new ResponseEntity<>(updateActionPoint, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActionPoint(@PathVariable("id") Long id) {
        ActionPointService.deleteActionPoint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
