package com.project.swisscomtask.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OwnerDto extends BaseDto implements Serializable {

    private String name;

    private String accountNumber;

    private int level;

}
