package com.project.swisscomtask.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OwnerDto extends BaseDto {

    private String name;

    private String accountNumber;

    private int level;

}
