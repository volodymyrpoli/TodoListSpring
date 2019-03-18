package com.tahometer.volodymyrpoli.todolistapp.entity.dto;

public class TaskDTO {

    private Integer id;
    private String title;
    private Boolean mark;
    private Integer projectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getMark() {
        return mark;
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}
