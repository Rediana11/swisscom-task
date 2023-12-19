package com.project.swisscomtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ServiceDto extends BaseDto implements Serializable {

    private String id;

    private List<ResourceDto> resources;

}
