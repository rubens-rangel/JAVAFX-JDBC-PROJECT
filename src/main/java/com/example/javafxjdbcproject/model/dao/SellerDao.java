package com.example.javafxjdbcproject.model.dao;


import com.example.javafxjdbcproject.model.entities.Department;
import com.example.javafxjdbcproject.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(Integer id);

    Seller findById(Integer id);

    List<Seller> findByDepartment(Department department);

    List<Seller> findAll();
}

