package com.titrate.reactportfolio.services;

import com.titrate.reactportfolio.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project save(Project project);
     void deleteById(long id);
     Project findProjectById(long id);

}
