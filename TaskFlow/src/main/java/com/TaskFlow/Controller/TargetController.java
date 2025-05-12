package com.TaskFlow.Controller;

import com.TaskFlow.Services.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {

    @Autowired
    private TargetService targetSevice;

    @GetMapping("/project/target")
    public ResponseEntity<?> targetProject()
    {
        return targetSevice.targetProject();
    }

    @GetMapping("/task/target")
    public ResponseEntity<?> targetTask()
    {
        return targetSevice.targetTask();
    }
}
