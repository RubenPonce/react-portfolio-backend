package com.titrate.reactportfolio.services;

import com.titrate.reactportfolio.models.Project;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    List<Project> findAll(Pageable pageable);
    Project save(Project project);
     void deleteById(long id);
     Project findProjectById(long id);

}
