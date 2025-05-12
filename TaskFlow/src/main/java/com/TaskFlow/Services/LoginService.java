package com.TaskFlow.Services;

import com.TaskFlow.Entity.RegisterEntity;
import com.TaskFlow.Entity.UserEntity;
import com.TaskFlow.Repositry.RegisterRepo;
import com.TaskFlow.SecurityConfig.JwtTokenCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private JwtTokenCreation jwtTokenCreation;

    public ResponseEntity<?> login(UserEntity login)
    {
        RegisterEntity user = registerRepo.findByEmail(login.getEmail());
        if(user != null)
        {
            if(passwordEncoder.matches(login.getPassword(),user.getPassword()))
            {
                String token = jwtTokenCreation.makeToken(user.getEmail(),user.getRole());
                return ResponseEntity.ok("Token : " + token);
            }
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Retry login");
    }
}
