package com.project.swisscomtask.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OwnerEntity extends BaseEntity {

    private String name;

    private String accountNumber;

    private int level;

}
