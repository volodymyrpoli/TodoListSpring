package com.tahometer.volodymyrpoli.todolistapp.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {

    private Integer id;
    private String title;
    private Boolean mark;
    private Integer projectId;

}
