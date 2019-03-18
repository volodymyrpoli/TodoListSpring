package com.tahometer.volodymyrpoli.todolistapp.controller;

import com.tahometer.volodymyrpoli.todolistapp.entity.Project;
import com.tahometer.volodymyrpoli.todolistapp.entity.dto.ProjectDTO;
import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("{id}")
    public Project getProject(@PathVariable("id") Integer id) throws NotFoundException {
        return projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find project with id=" + id.toString()));
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectDTO projectDTO) {
        Project project = new Project();

        project.setName(projectDTO.getName());
        project.setPinned(false);

        return projectRepository.save(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") Integer id) {
        projectRepository.deleteById(id);
    }

    @PatchMapping("{id}")
    public Project patchProject(@PathVariable("id") Integer id, @RequestBody ProjectDTO projectDTO) throws NotFoundException {
        Project foundProject = projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find project with id=" + id.toString()));
        if (Objects.nonNull(projectDTO.getName())){
            foundProject.setName(projectDTO.getName());
        }
        if (Objects.nonNull(projectDTO.getPinned())) {
            foundProject.setPinned(projectDTO.getPinned());
        }

        return projectRepository.save(foundProject);
    }

}
