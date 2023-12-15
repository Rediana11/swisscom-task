package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.ServiceDto;
import com.project.swisscomtask.model.ServiceEntity;

public interface ServiceMapper {

    ServiceDto toDto(ServiceEntity entity);

    ServiceEntity toEntity(ServiceDto dto);
}