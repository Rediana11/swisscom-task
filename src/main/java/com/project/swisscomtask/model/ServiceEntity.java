package com.project.swisscomtask.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "service")
public class ServiceEntity extends BaseEntity {

    private List<ResourceEntity> resources;

}
