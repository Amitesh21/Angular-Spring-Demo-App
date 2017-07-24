package com.sap.openapi.controller;

import com.sap.openapi.model.Employee64;
import com.sap.openapi.service.Employee64Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.io.FileInputStream;
import java.util.List;
import org.apache.tomcat.util.codec.binary.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by i861135 on 7/13/17.
 */
@RestController
public class Employee64Controller {

    @Autowired
    private Employee64Service employee64Service;

    @RequestMapping(value = "/employee64", method = RequestMethod.POST)
    public ResponseEntity saveEmployee(@RequestParam("emp_id") int emp_id, @RequestParam("emp_name") String emp_name, @RequestParam("emp_img") String emp_img){
        File file =  new File(emp_img);

        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
//            encodedfile = Base64.encodeBase64(bytes).toString();
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Employee64 e = new Employee64(emp_id, emp_name, encodedfile);
        employee64Service.saveEmployee(e);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee64", method = RequestMethod.GET)
    public ResponseEntity getAllEmployee(){
        List<Employee64> empList = employee64Service.getAllEmployee();
        return (empList == null) ?  new ResponseEntity(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity(empList, HttpStatus.OK);
    }
}
