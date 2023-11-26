package com.duallo.app.rest.service;

import com.duallo.app.rest.model.Tag;
import com.duallo.app.rest.model.Task;
import com.duallo.app.rest.repo.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepo;
    public List<Tag> getTags() {
        return tagRepo.findAll();
    }
    public Tag getTag(long id) {
        return tagRepo.findById(id).orElse(null);
    }
    public Tag saveTag(Tag tag) {
        Tag tagSaved = new Tag();
        BeanUtils.copyProperties(tag, tagSaved);
        return tagRepo.save(tag);
    }
    public Tag updateTag(long id, Tag tag) {
        Tag updatedTag = tagRepo.findById(id).orElse(null);
        if (updatedTag != null) {
            if (tag.getName() != null) {
                updatedTag.setName(tag.getName());
            }
            if (tag.getDescription() != null) {
                updatedTag.setDescription(tag.getDescription());
            }
            return tagRepo.save(updatedTag);
        } else {
            return null;
        }
    }
    public Boolean deleteTag(long id) {
        Tag deleteTag = tagRepo.findById(id).orElse(null);
        if(deleteTag != null) {
            tagRepo.delete(deleteTag);
            return true;
        } else {
            return false;
        }
    }
}
