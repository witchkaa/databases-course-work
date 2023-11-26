package com.duallo.app.rest.controller;

import com.duallo.app.rest.model.Task;
import com.duallo.app.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duallo/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping(value="task{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable long id) {
        Task task = taskService.getTask(id);
        if(task != null) {
            return ResponseEntity.status(HttpStatus.OK).body(task);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @GetMapping(value="/get")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
    @PostMapping(value = "/addtask")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        Task taskSaved = taskService.saveTask(task);
        if(taskSaved != null) {
            return new ResponseEntity<>("Task has been saved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Could not save the task", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value="/task{id}")
    public ResponseEntity<String> updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if(updatedTask != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Task has been edited successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task not found.");
        }
    }
    @DeleteMapping(value="/task{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id) {
        Boolean isDel = taskService.deleteTask(id);
        if(isDel) {
            return ResponseEntity.status(HttpStatus.OK).body("Task has been deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task not found.");
        }
    }
}
