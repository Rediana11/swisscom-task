package com.project.swisscomtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResourceDto extends BaseDto {

    private List<OwnerDto> owners;

}
