package com.titrate.reactportfolio.controllers;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.services.ProjectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Project%20End%20Points",produces = "MediaType.APPLICATION_JSON_VALUE", tags = {"Project End Points"},description = "Where the magic for my projects happen.")
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;


    @ApiOperation(value="Lists all the current projects on ruben-ponce.com by 3 projects at a time",nickname = "find projects")
    @GetMapping(value = "/projects", produces = {"application/json"})
    public ResponseEntity<?> findAllProjects(@PageableDefault(page=0, size = 3) Pageable pageable){
        return new ResponseEntity<>(projectService.findAll(pageable), HttpStatus.OK);
    }

    @ApiOperation(value="creates a new project")
    @ApiResponses(value = {
    @ApiResponse(code= 201, message = "successfully created"),
    @ApiResponse(code=400, message = "Bad Request, enter a proper JSON object")
    })
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
