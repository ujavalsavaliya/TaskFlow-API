package com.TaskFlow.Repositry;

import com.TaskFlow.Entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository <ProjectEntity,Integer> {
    public void deleteById(int id);
}
