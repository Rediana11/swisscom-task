package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.OwnerDto;
import com.project.swisscomtask.model.OwnerEntity;

public interface OwnerMapper {

    OwnerDto toDto(OwnerEntity entity);

    OwnerEntity toEntity(OwnerDto dto);
}