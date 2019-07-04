package com.titrate.reactportfolio.controllers;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.services.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/projects")
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
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "deletes a project by their id")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "project deleted successfully"),
    @ApiResponse(code = 500, message = "No Project entity with id of {integer} exists!")})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>("project deleted successfully", HttpStatus.ACCEPTED);
    }
}
