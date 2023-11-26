package com.duallo.app.rest.service;

import com.duallo.app.rest.model.Label;
import com.duallo.app.rest.repo.LabelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepo;
    public List<Label> getLabelByTask(long id) {
        return labelRepo.findByTaskID(id);
    }
    public List<Label> getLabelByTag(long id) {
        return labelRepo.findByTagID(id);
    }
    public Label getLabelByTagAndTask(long taskID, long tagID) {
        return labelRepo.findByTaskIDAndTagID(taskID, tagID).orElse(null);
    }
    public List<Label> getLabels() {
        return labelRepo.findAll();
    }
    public Label getLabel(long id) {
        return labelRepo.findById(id).orElse(null);
    }
    public Label saveLabel(Label label) {
        Label labelSaved = new Label();
        BeanUtils.copyProperties(label, labelSaved);
        return labelRepo.save(labelSaved);
    }
    public Label updateLabel(long id, Label label) {
        Label updatedLabel = labelRepo.findById(id).orElse(null);
        if(updatedLabel != null) {
            if(label.getTagID() != null) {
                updatedLabel.setTagID(label.getTagID());
            }
            if(label.getTaskID() != null) {
                updatedLabel.setTaskID(label.getTaskID());
            }
            return labelRepo.save(updatedLabel);
        } else {
            return null;
        }
    }
    public Boolean deleteLabel(long id) {
        Label deleteLabel = labelRepo.findById(id).orElse(null);
        if (deleteLabel != null) {
            labelRepo.delete(deleteLabel);
            return true;
        } else {
            return false;
        }
    }
}
