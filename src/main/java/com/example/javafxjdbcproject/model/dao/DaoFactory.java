package com.example.javafxjdbcproject.model.dao;


import com.example.javafxjdbcproject.db.DB;
import com.example.javafxjdbcproject.model.dao.impl.DepartmentDaoJDBC;
import com.example.javafxjdbcproject.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }

}
