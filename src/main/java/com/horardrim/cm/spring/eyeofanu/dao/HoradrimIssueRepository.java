package com.horardrim.cm.spring.eyeofanu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.horardrim.cm.spring.eyeofanu.model.issue.HoradrimIssue;

@Repository
public interface HoradrimIssueRepository extends CrudRepository<HoradrimIssue, Long>{
    
}
