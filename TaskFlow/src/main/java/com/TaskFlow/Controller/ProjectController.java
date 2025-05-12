package com.TaskFlow.Controller;

import com.TaskFlow.Entity.ProjectEntity;
import com.TaskFlow.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<?> create_project(@RequestBody ProjectEntity projectEntity)
    {
        return projectService.create_project(projectEntity);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProject()
    {
        return projectService.get_all_project();
    }

    @GetMapping
    public ResponseEntity<?> ownproject()
    {
        return projectService.own_project();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProject(@RequestBody ProjectEntity projectEntity,@PathVariable int id)
    {
        return projectService.update_project(projectEntity,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteproject(@PathVariable int id)
    {
        return projectService.delete_project(id);
    }

}
