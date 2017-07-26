package com.sap.openapi.controller;

import com.sap.openapi.model.UserDetails;
import org.apache.catalina.util.ManifestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sap.openapi.service.LoginService;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by i861135 on 6/30/17.
 */
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("password") String password){
        //LOG.debug("Entering Login Validation", username, pwd);
        System.out.println("email: password");
        System.out.println("email: "+email+"   pwd:  "+password);
        return loginService.validateAccount(email, password) ?
                new ResponseEntity("Success", HttpStatus.OK) : new ResponseEntity("Error: Invalid Credentials", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/register")
    public ResponseEntity<UserDetails> register(@RequestBody UserDetails user){

        UserDetails userDetails = new UserDetails(user.getName(), user.getEmail(), user.getPassword());
        loginService.register(userDetails);
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{email:.+}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
     public  ResponseEntity<UserDetails> getUser(@PathVariable("email") String email){
        //LOG.debug("Fetching user detail: ", email);
        UserDetails user = loginService.findById(1);
        return (user == null) ?  new ResponseEntity(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<UserDetails> deleteUser(@PathVariable("id") int uid){
        //LOG.debug("Fetching user detail: ", email);
        loginService.deleteUser(uid);
        return new ResponseEntity(null, HttpStatus.OK);
    }


    @RequestMapping (value = "/users", method = RequestMethod.GET)
    public  ResponseEntity<List<UserDetails>> getAllUser(){
        //LOG.debug("Finding All User Details");
        List<UserDetails> list = loginService.getAllUser();
        System.out.println("User list is: "+list);
//        return list;
        return (list == null) ?  new ResponseEntity(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity(list, HttpStatus.OK);
    }

//    @CrossOrigin
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public List<UserDetails> getAllUser(){
//        //LOG.debug("Finding All User Details");
//        List<UserDetails> list = loginService.getAllUser();
//        System.out.println("User list is: "+list);
//        return list;
//    }
}
