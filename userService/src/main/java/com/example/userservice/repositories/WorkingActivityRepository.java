package com.example.userservice.repositories;

import com.example.userservice.models.WorkingActivity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkingActivityRepository extends CrudRepository<WorkingActivity, Long> {
    List<WorkingActivity> findByCompanyName (String companyName);

    List<WorkingActivity> findByUsername (String username);


}
