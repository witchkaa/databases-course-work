package com.duallo.app.rest.controller;

import com.duallo.app.rest.model.Label;
import com.duallo.app.rest.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duallo/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;
    @GetMapping(value="/get")
    public List<Label> getLabels() {
        return labelService.getLabels();
    }
    @GetMapping(value="/label{id}")
    public ResponseEntity<Label> getLabelByID(@PathVariable long id) {
        Label label = labelService.getLabel(id);
        if(label != null) {
            return ResponseEntity.status(HttpStatus.OK).body(label);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping(value = "/task{id}")
    public ResponseEntity<List<Label>> getLabelsByTask(@PathVariable long id) {
        List<Label> labels = labelService.getLabelByTask(id);
        if(labels != null) {
            return ResponseEntity.status(HttpStatus.OK).body(labels);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping(value = "/tag{id}")
    public ResponseEntity<List<Label>> getLabelsByTag(@PathVariable long id) {
        List<Label> labels = labelService.getLabelByTag(id);
        if(labels != null) {
            return ResponseEntity.status(HttpStatus.OK).body(labels);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping(value = "/tag{tagID}/task{taskID}")
    public ResponseEntity<Label> getLabelByTagAndTask(@PathVariable long taskID, @PathVariable long tagID) {
        Label label = labelService.getLabelByTagAndTask(taskID, tagID);
        if(label != null) {
            return ResponseEntity.status(HttpStatus.OK).body(label);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping(value = "/addlabel")
    public ResponseEntity<String> addLabel(@RequestBody Label label) {
        Label labelSaved = labelService.saveLabel(label);
        if(labelSaved != null) {
            return new ResponseEntity<>("Label has been saved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not save the label", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value="/label{id}")
    public ResponseEntity<String> updateLabel(@PathVariable long id, @RequestBody Label label) {
        Label updatedLabel = labelService.updateLabel(id, label);
        if(updatedLabel != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Label has been edited successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Label not found.");
        }
    }
    @DeleteMapping(value="/label{id}")
    public ResponseEntity<String> deleteLabel(@PathVariable long id) {
        Boolean isDel = labelService.deleteLabel(id);
        if (isDel) {
            return ResponseEntity.status(HttpStatus.OK).body("Label has been deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Label not found.");
        }
    }
}
