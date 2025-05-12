package com.TaskFlow.Repositry;

import com.TaskFlow.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<RegisterEntity, Integer> {  // Change Integer to Long
    public RegisterEntity findByEmail(String Email);
    public RegisterEntity findByUsername(String username);
}
