package com.tahometer.volodymyrpoli.todolistapp.util;

import com.tahometer.volodymyrpoli.todolistapp.exception.NotFoundException;

import java.util.List;
import java.util.Map;

public class Util {
    public static Map<String, Object> patchEntityInArray(Integer id, Map<String, Object> taskPatch, List<Map<String, Object>> data) throws NotFoundException {
        Map<String, Object> projectFromDatabase = data.stream()
                .filter(project -> id.equals(project.get("id")))
                .findFirst()
                .orElseThrow(NotFoundException::new);

        projectFromDatabase.putAll(taskPatch);
        projectFromDatabase.put("id", id);
        return projectFromDatabase;
    }

    public static void removeFromArrayIf(Integer id, List<Map<String, Object>> data) throws NotFoundException {
        int countBeforeDelete = data.size();
        data.removeIf(project -> id.equals(project.get("id")));
        if (countBeforeDelete == data.size()) {
            throw new NotFoundException();
        }
    }
}
