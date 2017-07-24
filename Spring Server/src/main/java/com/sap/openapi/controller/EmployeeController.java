package com.sap.openapi.controller;

import com.sap.openapi.model.Employee;
import com.sap.openapi.repository.EmployeeRepository;
import com.sap.openapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by i861135 on 7/12/17.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity saveEmployee( @RequestParam("emp_id") int emp_id,  @RequestParam("emp_name") String emp_name, @RequestParam("emp_img") String emp_img){
        File file = new File("/Users/i861135/Documents/intellij proj/demo-app21 copy/src/main/resources/images/"+emp_img);
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee e = new Employee(emp_id, emp_name, bFile, bFile, bFile);
        employeeService.saveEmployee(e);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity getAllEmployee(){
        List<Employee> empList = employeeService.getAllEmployee();
        return (empList == null) ?  new ResponseEntity(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity(empList, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/manual", method = RequestMethod.GET)
    public ResponseEntity getAllEmployeeManually(){
        List<Object> employeeList = employeeService.getAllEmployeeManually();
        return (employeeList == null) ?  new ResponseEntity(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity(employeeList, HttpStatus.OK);
    }
}