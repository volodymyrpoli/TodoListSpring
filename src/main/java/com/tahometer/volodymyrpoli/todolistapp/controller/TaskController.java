package com.tahometer.volodymyrpoli.todolistapp.controller;

import com.tahometer.volodymyrpoli.todolistapp.entity.Project;
import com.tahometer.volodymyrpoli.todolistapp.entity.Task;
import com.tahometer.volodymyrpoli.todolistapp.entity.dto.TaskDTO;
import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.repository.ProjectRepository;
import com.tahometer.volodymyrpoli.todolistapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Integer id) {
        return taskRepository.getOne(id);
    }

    @GetMapping
    public List<Task> getTasksForProject(@RequestParam("projectId") Integer projectId) {
        if (Objects.isNull(projectId)) {
            return taskRepository.findAll();
        }
        return taskRepository.findAllByProjectId(projectId);
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) throws NotFoundException {
        Task task = new Task();

        map(taskDTO, task);

        if (Objects.nonNull(taskDTO.getProjectId())) {
            Project project = projectRepository
                    .findById(taskDTO.getProjectId())
                    .orElseThrow(() -> new NotFoundException("Can't find project with id=" + taskDTO.getProjectId()));
            task.setProject(project);
        }

        return taskRepository.save(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("{id}")
    public Task patchTask(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) throws NotFoundException {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find task with id=" + id.toString()));
        map(taskDTO, task);
        return taskRepository.save(task);
    }

    private void map(TaskDTO taskDTO, Task task) {
        if (Objects.nonNull(taskDTO.getTitle())) {
            task.setTitle(taskDTO.getTitle());
        }

        if (Objects.nonNull(taskDTO.getMark())) {
            task.setMark(taskDTO.getMark());
        }
    }

}
