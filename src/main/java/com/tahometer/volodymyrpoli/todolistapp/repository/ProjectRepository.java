package com.tahometer.volodymyrpoli.todolistapp.repository;

import com.tahometer.volodymyrpoli.todolistapp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
