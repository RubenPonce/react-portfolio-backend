package com.titrate.reactportfolio.repositories;

import com.titrate.reactportfolio.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
