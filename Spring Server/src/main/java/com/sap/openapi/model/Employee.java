package com.sap.openapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by i861135 on 7/12/17.
 */
@Entity
public class Employee {

    @Id
    private int emp_id;
    private String emp_name;
    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] emp_image;
    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] emp_image1;
    @Lob
    @Column(columnDefinition="mediumblob")
    private byte[] emp_image2;

    public Employee() {
    }

    public Employee(int emp_id, String emp_name, byte[] emp_image, byte[] emp_image1, byte[] emp_image2) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_image = emp_image;
        this.emp_image1 = emp_image1;
        this.emp_image2 = emp_image2;
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

    public byte[] getEmp_image() {
        return emp_image;
    }

    public void setEmp_image(byte[] emp_image) {
        this.emp_image = emp_image;
    }

    public byte[] getEmp_image1() {
        return emp_image1;
    }

    public void setEmp_image1(byte[] emp_image1) {
        this.emp_image1 = emp_image1;
    }

    public byte[] getEmp_image2() {
        return emp_image2;
    }

    public void setEmp_image2(byte[] emp_image2) {
        this.emp_image2 = emp_image2;
    }
}
