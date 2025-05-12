package com.TaskFlow.Repositry;

import com.TaskFlow.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
    public List<TaskEntity> findByProjectId(int id);
    public void deleteById(int id);
}
