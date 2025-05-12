package com.TaskFlow.Services;

import com.TaskFlow.Entity.ProjectEntity;
import com.TaskFlow.Repositry.ProjectRepo;
import com.TaskFlow.Repositry.RegisterRepo;
import com.TaskFlow.SecurityConfig.JwtAuthFilter;
import com.TaskFlow.SecurityConfig.Validate_Data;
import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private EmailService emailService;

    @Autowired
    private Validate_Data validate_data;

    public ResponseEntity<?> create_project(ProjectEntity projectEntity) {
        validate_data.project_validation(projectEntity);
        projectRepo.save(projectEntity);
        for(String s : projectEntity.getUser())
        {
            String email = registerRepo.findByUsername(s).getEmail();
            emailService.sendEmail(projectEntity.getName(),projectEntity.getDescription(),email,s);
        }
        return ResponseEntity.ok().body("Project assigned successfully");
    }

    public ResponseEntity<?> get_all_project()
    {
        return ResponseEntity.ok().body(projectRepo.findAll().stream().sorted(Comparator.comparing(ProjectEntity::getDeadline, Comparator.nullsLast(Comparator.naturalOrder()))));
    }

    public ResponseEntity<?> own_project() {
        String username = jwtAuthFilter.email.getUsername();
        List<ProjectEntity> allproject = projectRepo.findAll();
        List<ProjectEntity> ownproject = new ArrayList<>();
        for(ProjectEntity p : allproject)
        {
            HashSet<String> set = new HashSet<>(p.getUser());
            if(set.contains(username))
            {
                ownproject.add(p);
            }
        }
        return ResponseEntity.ok().body(ownproject.stream().sorted(Comparator.comparing(ProjectEntity::getDeadline, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update_project(@RequestBody ProjectEntity projectEntity,int id)
    {
        validate_data.project_validation(projectEntity);
        projectRepo.deleteById(id);
        projectRepo.save(projectEntity);
        return ResponseEntity.ok().body("Updated Successfully");
    }

    public ResponseEntity<?> delete_project(int id)
    {
        projectRepo.deleteById(id);
        return ResponseEntity.ok().body("Deleted Successfully");
    }


}
