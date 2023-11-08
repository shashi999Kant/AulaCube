package com.aula.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.Exceptions.DepartmentNotFoundException;
import com.aula.Repository.DepartmentRepository;
import com.aula.entities.Department;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        // Set creation and update timestamps
        department.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        department.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String id, Department updatedDepartment) {
        // Retrieve the existing department
        Department existingDepartment = departmentRepository.findById(id)
            .orElseThrow(() -> new DepartmentNotFoundException(id));

        // Update the fields you want
        existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());

        // Set the update timestamp
        existingDepartment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
