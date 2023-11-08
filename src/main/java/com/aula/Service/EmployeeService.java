package com.aula.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.Exceptions.EmployeeNotFoundException;
import com.aula.Repository.EmployeeRepositry;
import com.aula.entities.Employe;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositry employeeRepository;

    public List<Employe> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employe createEmployee(Employe employee) {
        // Set creation and update timestamps
        employee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        employee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return employeeRepository.save(employee);
    }

    public Employe updateEmployee(Long id, Employe updatedEmployee) {
        // Retrieve the existing employee
        Employe existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));

        // Update the fields you want
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());

        // Set the update timestamp
        existingEmployee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
