package com.titrate.reactportfolio;

import com.titrate.reactportfolio.models.Project;
import com.titrate.reactportfolio.models.Role;
import com.titrate.reactportfolio.models.User;
import com.titrate.reactportfolio.models.UserRoles;
import com.titrate.reactportfolio.services.ProjectService;
import com.titrate.reactportfolio.services.RoleService;
import com.titrate.reactportfolio.services.UserService;
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

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

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
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);


        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);
    }
}
