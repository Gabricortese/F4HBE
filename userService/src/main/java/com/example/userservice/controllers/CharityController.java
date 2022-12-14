package com.example.userservice.controllers;

import com.example.userservice.models.CharityCompany;
import com.example.userservice.repositories.CharityCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class CharityController {

    @Autowired
    CharityCompanyRepository repository;

    @PostMapping(value = "/charity/create")
    public CharityCompany postCharity(@RequestBody CharityCompany charity) {
        CharityCompany _charity = repository.save(new CharityCompany(charity.getID(),charity.getCompanyName(),charity.getCEO_name(),charity.getAddress(), charity.getPhone_number(), charity.getUsername(),charity.getPassword(),charity.getClientid()));
        return _charity;
    }

    @GetMapping("charities")
    public List<CharityCompany> getAllCharity() {
        System.out.println("Get all Charity activities...");

        List<CharityCompany> charities = new ArrayList<>();
        repository.findAll().forEach(charities::add);

        return charities;
    }

    @DeleteMapping("/charity/delete/{id}")
    public ResponseEntity<String> deleteCharity(@PathVariable("id") long id) {
        System.out.println("Delete Charity with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Charity has been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/charity/name/{name}")
    public List<CharityCompany> findByCompanyName(@PathVariable String name) {

        List<CharityCompany> charities = repository.findByCompanyName(name);
        return charities;
    }

    @GetMapping(value = "/charity/login/{userpwd}")
    public CharityCompany loginCharity(@PathVariable String userpwd) {

        if(!userpwd.contains("_"))
            return null;

        String username = userpwd.split("_")[0];
        String password = userpwd.split("_")[1];

        List<CharityCompany> charities = repository.findByUsername(username);

        boolean exists = false;
        CharityCompany current_user = null;


        for (CharityCompany ch : charities) {
            if(ch.getUsername().equals(username)){
                exists = true;
                current_user = ch;
                if(!ch.getPassword().equals(password))
                    exists = false;
                break;
            }
        }

        if(exists)
            return current_user;
        else
            return null;
    }

    @GetMapping(value = "/charity/login/google/{clientid}")
    public CharityCompany loginGoogle(@PathVariable String clientid) {

        List<CharityCompany> charities = new ArrayList<>();
        repository.findAll().forEach(charities::add);

        boolean exists = false;
        CharityCompany current_user = null;


        for (CharityCompany ch : charities) {
            if(ch.getClientid().equals(clientid)){
                exists = true;
                current_user = ch;
                break;
            }
        }

        if(exists)
            return current_user;
        else
            return null;
    }


}
