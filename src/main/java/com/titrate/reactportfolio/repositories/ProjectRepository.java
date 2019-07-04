package com.titrate.reactportfolio.repositories;

import com.titrate.reactportfolio.models.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

}
