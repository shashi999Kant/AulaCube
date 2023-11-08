package com.aula.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aula.entities.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
