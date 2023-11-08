package com.aula.Exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String id) {
        super("Department not found with ID: " + id);
    }
}