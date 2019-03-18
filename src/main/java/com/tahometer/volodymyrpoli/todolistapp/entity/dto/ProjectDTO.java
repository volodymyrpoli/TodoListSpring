package com.tahometer.volodymyrpoli.todolistapp.entity.dto;

public class ProjectDTO {

    private Integer id;
    private String name;
    private Boolean pinned;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

}
