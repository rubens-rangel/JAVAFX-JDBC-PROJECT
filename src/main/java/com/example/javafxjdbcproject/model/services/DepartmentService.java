package com.example.javafxjdbcproject.model.services;

import com.example.javafxjdbcproject.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Department> findAll(){
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Books"));
        list.add(new Department(1, "Computers"));
        list.add(new Department(1, "Eletronics"));
        return list;
    }

}
