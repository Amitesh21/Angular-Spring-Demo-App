package com.sap.openapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.sap.openapi.model.UserDetails;
/**
 * Created by i861135 on 6/30/17.
 */
public interface LoginRepository  extends CrudRepository<UserDetails, String>{

}
