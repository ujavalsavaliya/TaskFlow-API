package com.TaskFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String description;

    private int projectId;

    @ElementCollection
    private List<String> assigned_users ;

    @Enumerated(EnumType.STRING)
    private status status;

    private LocalDate due_date;

    public enum status{
        TODO,
        IN_PROGRESS,
        DONE
    }
}
