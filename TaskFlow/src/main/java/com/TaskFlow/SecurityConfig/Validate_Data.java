package com.TaskFlow.SecurityConfig;

import com.TaskFlow.Entity.ProjectEntity;
import com.TaskFlow.Entity.RegisterEntity;
import com.TaskFlow.Entity.TaskEntity;
import com.TaskFlow.Exception.detailsAreInvalid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Validate_Data {
    public void project_validation(ProjectEntity projectEntity)
    {
        if(projectEntity.getName() == null || projectEntity.getDescription() == null || projectEntity.getUser().isEmpty() || LocalDate.now().isAfter(projectEntity.getDeadline()))
        {
            throw new detailsAreInvalid("Enter valid Details");
        }
    }
    public void register_validation(RegisterEntity registerEntity)
    {
        if (isNullOrBlank(registerEntity.getEmail()) ||
                isNullOrBlank(registerEntity.getPassword()) ||
                isNullOrBlank(registerEntity.getUsername()) ||
                !registerEntity.getUsername().matches(".*[a-zA-Z].*") ||
                !registerEntity.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
        )
        {
            throw new detailsAreInvalid("Enter valid details");
        }
    }
    private boolean isNullOrBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
    public void task_validation(TaskEntity taskEntity)
    {
        if(isNullOrBlank(taskEntity.getTitle()) ||
                isNullOrBlank(taskEntity.getDescription()) ||
                taskEntity.getAssigned_users().isEmpty() ||
                LocalDate.now().isAfter(taskEntity.getDue_date()))
        {
            throw new detailsAreInvalid("Enter valid deails");
        }
    }

}