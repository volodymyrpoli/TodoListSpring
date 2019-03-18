package com.tahometer.volodymyrpoli.todolistapp.repository;

import com.tahometer.volodymyrpoli.todolistapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    <S extends Task> List<S> findAllByProjectId(Integer id);

}
