package com.project.swisscomtask.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BaseEntity {

    @Id
    private String id;

    private String criticalText;

}
