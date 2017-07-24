package com.sap.openapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by i861135 on 7/12/17.
 */
@Entity
public class Employee64 {

    @Id
    private int emp_id;
    private String emp_name;
    @Lob
    private String emp_image;

    public Employee64() {
    }

    public Employee64(int emp_id, String emp_name, String emp_image) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_image = emp_image;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_image() {
        return emp_image;
    }

    public void setEmp_image(String emp_image) {
        this.emp_image = emp_image;
    }

}
