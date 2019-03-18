package com.tahometer.volodymyrpoli.todolistapp.controller;

import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("{id}")
    public Map<String, Object> getTask(@PathVariable("id") Integer id) throws NotFoundException {
        return taskRepository.getTask(id);
    }

    @GetMapping
    public List<Map<String, Object>> getTasksForProject(@RequestParam("projectId") Integer projectId) {
        if (Objects.isNull(projectId)) {
            return taskRepository.getTasks();
        }
        return taskRepository.getTasksByProjectId(projectId);
    }

    @PostMapping
    public Map<String, Object> createTask(@RequestBody Map<String, Object> task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Integer id) throws NotFoundException {
        taskRepository.delete(id);
    }

    @PatchMapping("{id}")
    public Map<String, Object> patchTask(@PathVariable("id") Integer id, @RequestBody Map<String, Object> task) throws NotFoundException {
        return taskRepository.patch(id, task);
    }


}
