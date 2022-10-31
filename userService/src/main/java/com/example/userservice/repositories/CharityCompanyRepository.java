package com.example.userservice.repositories;

import com.example.userservice.models.CharityCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharityCompanyRepository extends CrudRepository<CharityCompany, Long> {
    List<CharityCompany> findByCompanyName (String companyName);

    List<CharityCompany> findByUsername (String username);


}
