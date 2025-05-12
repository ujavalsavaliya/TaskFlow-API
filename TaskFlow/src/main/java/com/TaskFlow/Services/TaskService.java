package com.TaskFlow.Services;

import com.TaskFlow.Entity.TaskEntity;
import com.TaskFlow.Repositry.RegisterRepo;
import com.TaskFlow.Repositry.TaskRepo;
import com.TaskFlow.SecurityConfig.JwtAuthFilter;
import com.TaskFlow.SecurityConfig.Validate_Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;
    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private Validate_Data validate_data;

    public ResponseEntity<?> createTask(TaskEntity taskEntity,int id)
    {
        validate_data.task_validation(taskEntity);
        taskEntity.setProjectId(id);
        taskRepo.save(taskEntity);
        for(String s : taskEntity.getAssigned_users())
        {
            String email = registerRepo.findByUsername(s).getEmail();
            emailService.sendEmail(taskEntity.getTitle(),taskEntity.getDescription() + taskEntity.getStatus() + taskEntity.getProjectId() ,email,s);
        }
        return ResponseEntity.ok().body("Task assigned successfully");
    }

    public ResponseEntity<?> getTaskInProject(int id)
    {
        List<TaskEntity> taskInProject = taskRepo.findByProjectId(id);
        return ResponseEntity.ok().body(taskInProject.stream().sorted(Comparator.comparing(TaskEntity::getDue_date, Comparator.nullsLast(Comparator.naturalOrder()))));
    }

    public ResponseEntity<?> ownTask()
    {
        String username = jwtAuthFilter.email.getUsername();
        List<TaskEntity> alltask = taskRepo.findAll();
        List<TaskEntity> owntask = new ArrayList<>();
        for(TaskEntity t : alltask)
        {
            HashSet<String> set = new HashSet<>(t.getAssigned_users());
            if(set.contains(username))
            {
                owntask.add(t);
            }
        }
        return ResponseEntity.ok().body(owntask.stream().sorted(Comparator.comparing(TaskEntity::getDue_date, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList()));
    }

    public ResponseEntity<?> updateTask(TaskEntity taskEntity,int id)
    {
        validate_data.task_validation(taskEntity);
        taskRepo.deleteById(id);
        taskRepo.save(taskEntity);
        return ResponseEntity.ok().body("Updated Successfully");
    }

    public ResponseEntity<?> deleteTask(int id)
    {
        taskRepo.deleteById(id);
        return ResponseEntity.ok().body("Deleted Successfully");
    }
}
