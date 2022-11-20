package com.example.logged_user.controllers;

import com.example.logged_user.models.UserLogged;
import com.example.logged_user.repositories.UserLoggedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/userlogged")
public class UserLoggedController {

    @Autowired
    UserLoggedRepository repository;

    @PostMapping(value = "/create")
    public UserLogged postCharity(@RequestBody UserLogged u) {
        UserLogged _u = repository.save(new UserLogged(u.getId(), u.getCompanyName(), u.getCeo_name(), u.getAddress(), u.getPhone_number(), u.getUsername(), u.getPassword()));
        return _u;
    }

    @GetMapping("getuser")
    public List<UserLogged> getUserLogged() {
        System.out.println("Get single user lgoged...");

        List<UserLogged> u = new ArrayList<>();
        repository.findAll().forEach(u::add);

        return u;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserLogged(@PathVariable("id") long id) {
        System.out.println("Delete UserLogged with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("UserLogged has been deleted!", HttpStatus.OK);
    }



}
