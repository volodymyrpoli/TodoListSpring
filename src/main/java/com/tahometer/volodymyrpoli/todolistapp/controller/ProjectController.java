package com.tahometer.volodymyrpoli.todolistapp.controller;

import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getProjects() {
        return projectRepository.getProjects();
    }

    @GetMapping("{id}")
    public Map<String, Object> getProject(@PathVariable("id") Integer id) throws NotFoundException {
        return projectRepository.getProject(id);
    }

    @PostMapping
    public Map<String, Object> createProject(@RequestBody Map<String, Object> project) {
        return projectRepository.save(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") Integer id) throws NotFoundException {
        projectRepository.delete(id);
    }

    @PatchMapping("{id}")
    public Map<String, Object> patchProject(@PathVariable("id") Integer id, @RequestBody Map<String, Object> project) throws NotFoundException {
        return projectRepository.update(id, project);
    }
}
