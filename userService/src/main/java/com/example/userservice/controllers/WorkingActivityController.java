package com.example.userservice.controllers;

import com.example.userservice.models.WorkingActivity;
import com.example.userservice.repositories.WorkingActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class WorkingActivityController {

    @Autowired
    WorkingActivityRepository repository;

    @PostMapping(value = "/workingactivity/create")
    public WorkingActivity postWorkingActivity(@RequestBody WorkingActivity wactivity) {
        WorkingActivity _wactivity = repository.save(new WorkingActivity(wactivity.getID(),wactivity.getCompanyName(),wactivity.getCEO_name(),wactivity.getAddress(), wactivity.getPhone_number(), wactivity.getUsername(),wactivity.getPassword()));
        return _wactivity;
    }

    @GetMapping("/workingactivities")
    public List<WorkingActivity> getAllWorkingActivities() {
        System.out.println("Get all Workining activities...");

        List<WorkingActivity> wactivities = new ArrayList<>();
        repository.findAll().forEach(wactivities::add);

        return wactivities;
    }

    @DeleteMapping("/workingactivity/delete/{id}")
    public ResponseEntity<String> deleteWorkingActivity(@PathVariable("id") long id) {
        System.out.println("Delete Working activity with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Working activity has been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/workingactivity/name/{name}")
    public List<WorkingActivity> findByCompanyName(@PathVariable String name) {

        List<WorkingActivity> wactivities = repository.findByCompanyName(name);
        return wactivities;
    }

    @GetMapping(value = "/workingactivity/login/{userpwd}")
    public WorkingActivity loginWorkingActivity(@PathVariable String userpwd) {

        if(!userpwd.contains("_"))
            return null;

        String username = userpwd.split("_")[0];
        String password = userpwd.split("_")[1];

        List<WorkingActivity> wactivities = repository.findByUsername(username);

        boolean exists = false;
        WorkingActivity current_user = null;


        for (WorkingActivity wa : wactivities) {
            if(wa.getUsername().equals(username)){
                exists = true;
                current_user = wa;
                if(!wa.getPassword().equals(password))
                    exists = false;
                break;
            }
        }

        if(exists)
            return current_user;
        else
            return null;
    }
}
