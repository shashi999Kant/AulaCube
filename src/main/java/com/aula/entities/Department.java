package com.aula.entities;

import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "departments")
@Getter
@Setter
@AllArgsConstructor
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructors, getters, and setters
}
