package com.example.javafxjdbcproject.model.services;

import com.example.javafxjdbcproject.model.dao.DaoFactory;
import com.example.javafxjdbcproject.model.dao.DepartmentDao;
import com.example.javafxjdbcproject.model.entities.Department;
import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){
        return dao.findAll();
    }

    public void  saveOrUpdate(Department obj){
        if(obj.getId()==null){
            dao.insert(obj);
        }else {
            dao.update(obj);
        }
    }

    public void remove(Department obj){
        dao.deleteById(obj.getId());
    }

}
