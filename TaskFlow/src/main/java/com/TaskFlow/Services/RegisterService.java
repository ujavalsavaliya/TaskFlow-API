package com.TaskFlow.Services;

import com.TaskFlow.Entity.RegisterEntity;
import com.TaskFlow.Repositry.RegisterRepo;
import com.TaskFlow.SecurityConfig.Validate_Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Validate_Data validate_data;

    @Autowired
    private RegisterRepo registerRepo;

    public ResponseEntity<?> save(RegisterEntity userDetail)
    {
        validate_data.register_validation(userDetail);
        RegisterEntity list = registerRepo.findByEmail(userDetail.getEmail());
        if(list == null)
        {
            userDetail.setRole(RegisterEntity.Role.ADMIN);
            userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
            registerRepo.save(userDetail);
            return ResponseEntity.ok().body("User Created");
        }
        return ResponseEntity.badRequest().body("User is Not Created");
    }
}
