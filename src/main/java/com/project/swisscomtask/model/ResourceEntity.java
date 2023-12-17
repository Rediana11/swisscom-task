package com.project.swisscomtask.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceEntity extends BaseEntity {

    private List<OwnerEntity> owners;

}
