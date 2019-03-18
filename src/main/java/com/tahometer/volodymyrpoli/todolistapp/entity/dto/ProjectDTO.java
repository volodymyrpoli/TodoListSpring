package com.tahometer.volodymyrpoli.todolistapp.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDTO {

    private Integer id;
    private String name;
    private Boolean pinned;

}
