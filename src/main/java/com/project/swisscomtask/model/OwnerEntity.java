package com.project.swisscomtask.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document
public class OwnerEntity {

    private String id;

    private String criticalText;

    private String name;

    private String accountNumber;

    private int level;

}
