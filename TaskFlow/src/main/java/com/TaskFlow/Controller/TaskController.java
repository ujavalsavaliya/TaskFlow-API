package com.TaskFlow.Controller;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import com.TaskFlow.Entity.TaskEntity;
import com.TaskFlow.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create/{id}")
    public ResponseEntity<?> createtask(@RequestBody TaskEntity taskEntity, @PathVariable int id)
    {
        return taskService.createTask(taskEntity,id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskInProject(@PathVariable int id)
    {
        return taskService.getTaskInProject(id);
    }

    @GetMapping
    public ResponseEntity<?> myTask()
    {
        return taskService.ownTask();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@RequestBody TaskEntity taskEntity, @PathVariable int id)
    {
        return taskService.updateTask(taskEntity,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id)
    {
        return taskService.deleteTask(id);
    }
}
