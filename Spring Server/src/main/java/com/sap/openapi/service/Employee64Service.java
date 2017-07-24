package com.sap.openapi.service;

import com.sap.openapi.model.Employee64;
import com.sap.openapi.repository.Employee64Repository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i861135 on 7/13/17.
 */
@Service
public class Employee64Service {

    @Autowired
    private Employee64Repository employee64Repository;

    public void saveEmployee(Employee64 e){
        try {
            employee64Repository.save(e);
        }
        catch (HibernateException he){
            he.printStackTrace();
        }
    }

    public List<Employee64> getAllEmployee(){
        List<Employee64> empList = new ArrayList<>();
        try {
            employee64Repository.findAll()
                    .forEach(empList :: add);
        }
        catch (HibernateException he){
            he.printStackTrace();
        }
        return empList;
    }

}
