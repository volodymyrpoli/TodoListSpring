package com.tahometer.volodymyrpoli.todolistapp.repository;

import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.util.Util;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {

    private int lastId = 0;

    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("title", "First project task");
            put("mark", false);
            put("projectId", 1);
        }});
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("title", "First project second task");
            put("mark", false);
            put("projectId", 1);
        }});
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("title", "First project third task");
            put("mark", false);
            put("projectId", 2);
        }});
    }};

    public List<Map<String, Object>> getTasks() {
        return data;
    }

    public Map<String, Object> getTask(Integer id) throws NotFoundException {
        return data.stream()
                .filter(task -> id.equals(task.get("id")))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public Map<String, Object> save(Map<String, Object> task) {
        task.put("id", generateId());
        data.add(task);
        return task;
    }

    public void delete(Integer id) throws NotFoundException {
        Util.removeFromArrayIf(id, data);
    }

    public Map<String, Object> patch(Integer id, Map<String, Object> taskPatch) throws NotFoundException {
        return Util.patchEntityInArray(id, taskPatch, data);
    }

    public List<Map<String, Object>> getTasksByProjectId(Integer projectId) {
        return data.stream()
                .filter(task -> projectId.equals(task.get("projectId")))
                .collect(Collectors.toList());
    }

    private int generateId() {
        return ++lastId;
    }
}
