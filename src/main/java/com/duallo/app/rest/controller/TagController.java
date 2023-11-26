package com.duallo.app.rest.controller;

import com.duallo.app.rest.model.Tag;
import com.duallo.app.rest.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duallo/tags")
public class TagController {
    @Autowired
    private TagService tagService;
    @GetMapping(value="/get")
    public List<Tag> getTags() {
        return tagService.getTags();
    }
    @GetMapping(value="/tag{id}")
    public ResponseEntity<Tag> getTagByID(@PathVariable long id) {
        Tag tag =  tagService.getTag(id);
        if(tag != null) {
            return ResponseEntity.status(HttpStatus.OK).body(tag);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping(value = "/addtag")
    public ResponseEntity<String> addTag(@RequestBody Tag tag) {
        Tag tagSaved = tagService.saveTag(tag);
        if(tagSaved != null) {
            return new ResponseEntity<>("Tag has been saved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not save the tag", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value="/tag{id}")
    public ResponseEntity<String> updateTag(@PathVariable long id, @RequestBody(required = false) Tag tag) {
        Tag updatedTag = tagService.updateTag(id, tag);
        if (updatedTag != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Tag has been edited successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tag not found");
        }
    }
    @DeleteMapping(value="/tag{id}")
    public ResponseEntity<String> deleteTag(@PathVariable long id) {
        Boolean isDel = tagService.deleteTag(id);
        if(isDel) {
            return ResponseEntity.status(HttpStatus.OK).body("Tag has been deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tag not found.");
        }
    }

}
