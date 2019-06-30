package com.titrate.reactportfolio.services;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "projectService")
public class ProjectServicesImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectService projectService;
    @Override
    public List<Project> findAll() {
        List<Project> list = new ArrayList<>();
        projectRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    //Takes a passed object and then creates a new one to fill in the values
    @Transactional
    @Override
    public Project save(Project project) {
            Project newProject = new Project();
            newProject.setProjectname(project.getProjectname());
            newProject.setDemo(project.getDemo());
            newProject.setDescription(project.getDescription());
            for (String s : project.getTechnologies()){
                newProject.getTechnologies().add(s);
            }
            newProject.setSourcecode(project.getSourcecode());

            return projectRepository.save(project);
    }



}
