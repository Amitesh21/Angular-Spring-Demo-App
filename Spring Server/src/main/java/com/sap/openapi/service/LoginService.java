package com.sap.openapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.sap.openapi.repository.LoginRepository;
import com.sap.openapi.model.UserDetails;
/**
 * Created by i861135 on 6/30/17.
 */
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean validateAccount(String email, String pwd){
//        UserDetails user = loginRepository.findOne(email);
//        if (user == null)
//            return false;
//        return (user.getPassword().equals(pwd)) ? true : false;
        return true;
    }

    public void register(UserDetails user){
        System.out.println("inside register service"+user);
        loginRepository.save(user);
    }

    public UserDetails findById(int uid){
        return loginRepository.findOne(uid);
    }

    public void deleteUser(int uid){
        UserDetails user = loginRepository.findOne(uid);
        loginRepository.delete(user);
    }

    public List<UserDetails> getAllUser(){
        List<UserDetails> list = new ArrayList<>();
        loginRepository.findAll()
                .forEach(list :: add);
        return list;
    }

}
