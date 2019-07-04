package com.titrate.reactportfolio;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    ProjectService projectService;

    @Override
    public void run(String... args) throws Exception {
        ArrayList<String> technologies1 = new ArrayList<>();
        technologies1.add("javascript");
        technologies1.add("React");
        technologies1.add("Core Java");
        technologies1.add("Spring");
        technologies1.add("CSS");
        Project project1 = new Project("MUDAMUDAMUDAMUDA",technologies1, "MUDAMUDA MUDA MUDA", "muda", "muda");
        projectService.save(project1);

        ArrayList<String> technologies2 = new ArrayList<>();
        technologies2.add("HTML");
        technologies2.add("CSS");
        technologies2.add("Core Java");
        technologies2.add("Spring");
        technologies2.add("LESS");
        Project project2 = new Project("WRRRRRYYYYYYYYYYYYYYYYY",technologies2, "MUDAMUDA MUDA MUDA", "muda", "muda");
        projectService.save(project2);
    }
}
