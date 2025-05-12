package com.TaskFlow.Controller;

import com.TaskFlow.Entity.RegisterEntity;
import com.TaskFlow.Entity.UserEntity;
import com.TaskFlow.Services.LoginService;
import com.TaskFlow.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/health-check")
    public String health()
    {
        return "ok";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterEntity userDetail)
    {
        return registerService.save(userDetail);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserEntity user)
    {
        return loginService.login(user);
    }
}
