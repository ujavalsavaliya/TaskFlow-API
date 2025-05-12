package com.TaskFlow.Services;

import com.TaskFlow.Entity.ProjectEntity;
import com.TaskFlow.Entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TargetService {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    public ResponseEntity<?> targetProject()
    {
        LocalDate today = LocalDate.now();
        List<ProjectEntity> allProject = (List<ProjectEntity>)projectService.own_project().getBody();
        List<ProjectEntity> LastWeekProject = new ArrayList<>();
        for(ProjectEntity p : allProject)
        {
            if(p.getDeadline().isBefore(today.plusDays(7)))
            {
                LastWeekProject.add(p);
            }
        }
        return ResponseEntity.ok().body(LastWeekProject.stream().sorted(Comparator.comparing(ProjectEntity::getDeadline, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList()));
    }

    public ResponseEntity<?> targetTask()
    {
        LocalDate today = LocalDate.now();
        List<TaskEntity> allTask = (List<TaskEntity>) taskService.ownTask().getBody();
        List<TaskEntity> LastWeekTask = new ArrayList<>();
        for(TaskEntity t : allTask)
        {
            if(t.getDue_date().isBefore(today.plusDays(7)) && ! t.getStatus().equals(TaskEntity.status.DONE))
            {
                LastWeekTask.add(t);
            }
        }
        return ResponseEntity.ok().body(LastWeekTask.stream().sorted(Comparator.comparing(TaskEntity::getDue_date, Comparator.nullsLast(Comparator.naturalOrder()))));
    }
}
