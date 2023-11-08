package com.aula.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.entities.Employe;

public interface EmployeeRepositry extends JpaRepository<Employe, Long> {
    List<Employe> findByDepartmentId(String departmentId);
}
