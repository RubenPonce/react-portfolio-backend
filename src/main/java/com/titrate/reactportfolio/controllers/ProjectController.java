package com.titrate.reactportfolio.controllers;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/projects", produces = {"application/json"})
    public ResponseEntity<?> findAllProjects(){
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/createnewproject", consumes = {"application/json"})
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project){
        projectService.save(project);
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
