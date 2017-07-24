package com.sap.openapi.repository;

import com.sap.openapi.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
/**
 * Created by i861135 on 7/12/17.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT emp_id, emp_name FROM employee", nativeQuery = true)
    List<Object> findAllEmployee();

}
