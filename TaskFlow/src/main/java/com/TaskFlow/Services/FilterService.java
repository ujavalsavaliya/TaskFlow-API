package com.TaskFlow.Services;

import com.TaskFlow.Entity.ProjectEntity;
import com.TaskFlow.Entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    public ResponseEntity<?> get_next_project()
    {
        List<ProjectEntity> allProject = (List<ProjectEntity>)projectService.own_project().getBody();
        return ResponseEntity.ok().body(allProject.get(0));
    }

    public ResponseEntity<?> get_next_task()
    {
        List<TaskEntity> allTask = (List<TaskEntity>)taskService.ownTask().getBody();
        return ResponseEntity.ok().body(allTask.get(0));
    }

    public ResponseEntity<?> get_inprocess_task()
    {
        List<TaskEntity> allTask = (List<TaskEntity>)taskService.ownTask().getBody();
        List<TaskEntity> inprocess_task = new ArrayList<>();
        for(TaskEntity t : allTask)
        {
            if(t.getStatus().equals(TaskEntity.status.IN_PROGRESS))
            {
                inprocess_task.add(t);
            }
        }
        return ResponseEntity.ok().body(inprocess_task);
    }
}
