package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.ResourceDto;
import com.project.swisscomtask.model.ResourceEntity;

public interface ResourceMapper {

    ResourceDto toDto(ResourceEntity entity);

    ResourceEntity toEntity(ResourceDto dto);
}