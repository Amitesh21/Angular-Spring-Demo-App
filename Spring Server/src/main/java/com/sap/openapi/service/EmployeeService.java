package com.sap.openapi.service;

import com.sap.openapi.model.Employee;
import com.sap.openapi.repository.EmployeeRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i861135 on 7/12/17.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public void saveEmployee(Employee e){
        try {
            employeeRepository.save(e);
        }
        catch (HibernateException he){
            he.printStackTrace();
        }
    }

    public List<Employee> getAllEmployee(){
        List<Employee> empList = new ArrayList<>();
        try {
            employeeRepository.findAll()
                    .forEach(empList :: add);
        }
        catch (HibernateException he){
            he.printStackTrace();
        }
        return empList;
    }

    public List<Object> getAllEmployeeManually(){
        List<Object> list = new ArrayList<>();
        list = employeeRepository.findAllEmployee();
        return list;
    }
}
