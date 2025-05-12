package com.TaskFlow.Controller;

import com.TaskFlow.Services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterContoller {

    @Autowired
    private FilterService filterService;

    @GetMapping("/project/next")
    public ResponseEntity<?> get_next_project()
    {
        return filterService.get_next_project();
    }

    @GetMapping("/task/next")
    public ResponseEntity<?> get_next_task()
    {
        return filterService.get_next_task();
    }

    @GetMapping("/task/inprocess")
    public ResponseEntity<?> get_inprocess_task()
    {
        return filterService.get_inprocess_task();
    }
}
