package com.duallo.app.rest.service;

import com.duallo.app.rest.model.Task;
import com.duallo.app.rest.repo.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepo;
    public Task saveTask(Task task) {
        Task taskSaved = new Task();
        BeanUtils.copyProperties(task, taskSaved);
        return taskRepo.save(taskSaved);
    }
    public Task getTask(Long id) {
        return taskRepo.findById(id).orElse(null);
    }
    public List<Task> getTasks() {
        return taskRepo.findAll();
    }
    public Task updateTask(long id, Task task) {
        Task updatedTask = taskRepo.findById(id).orElse(null);
        if (updatedTask != null) {
            if (task.getName() != null) {
                updatedTask.setName(task.getName());
            }
            if (task.getDescription() != null) {
                updatedTask.setDescription(task.getDescription());
            }
            if (task.getDeadline() != null) {
                updatedTask.setDeadline(task.getDeadline());
            }
            if (task.getCreationDate() != null) {
                updatedTask.setCreationDate(task.getCreationDate());
            }
            if (task.getSprintID() != null) {
                updatedTask.setSprintID(task.getSprintID());
            }
            return taskRepo.save(updatedTask);
        } else {
            return null;
        }
    }
    public Boolean deleteTask(long id) {
        Task deleteTask = taskRepo.findById(id).orElse(null);
        if(deleteTask != null) {
            taskRepo.delete(deleteTask);
            return true;
        } else {
            return false;
        }
    }
}
