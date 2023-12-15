package com.project.swisscomtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ServiceDto {

    private String id;

    private String criticalText;

    private List<ResourceDto> resources;

}
