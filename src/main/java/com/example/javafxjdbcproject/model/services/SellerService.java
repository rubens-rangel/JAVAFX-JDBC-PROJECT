package com.example.javafxjdbcproject.model.services;

import com.example.javafxjdbcproject.model.dao.DaoFactory;
import com.example.javafxjdbcproject.model.dao.SellerDao;
import com.example.javafxjdbcproject.model.entities.Seller;

import java.util.List;

public class SellerService {

    private SellerDao dao = DaoFactory.createSellerDao();

    public List<Seller> findAll(){
        return dao.findAll();
    }

    public void  saveOrUpdate(Seller obj){
        if(obj.getId()==null){
            dao.insert(obj);
        }else {
            dao.update(obj);
        }
    }

    public void remove(Seller obj){
        dao.deleteById(obj.getId());
    }

}
