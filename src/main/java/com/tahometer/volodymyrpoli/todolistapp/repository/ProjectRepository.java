package com.tahometer.volodymyrpoli.todolistapp.repository;

import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;
import com.tahometer.volodymyrpoli.todolistapp.util.Util;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectRepository {

    private int lastId = 0;

    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("name", "First project");
            put("pinned", true);
        }});
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("name", "Second project");
            put("pinned", true);
        }});
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("name", "Third project");
            put("pinned", false);
        }});
        add(new HashMap<String, Object>() {{
            put("id", generateId());
            put("name", "Fourty project");
            put("pinned", false);
        }});
    }};

    public List<Map<String, Object>> getProjects() {
        return data;
    }

    public Map<String, Object> getProject(Integer id) throws NotFoundException {
        return data.stream()
                .filter(stringStringMap -> id.equals(stringStringMap.get("id")))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    public Map<String, Object> save(Map<String, Object> project) {
        project.put("id", generateId());
        data.add(project);
        return project;
    }

    public void delete(Integer id) throws NotFoundException {
        Util.removeFromArrayIf(id, data);
    }

    public Map<String, Object> update(Integer id, Map<String, Object> projectPatch) throws NotFoundException {
        return Util.patchEntityInArray(id, projectPatch, data);
    }

    private int generateId() {
        return ++lastId;
    }
}
