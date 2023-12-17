package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.ServiceDto;
import com.project.swisscomtask.model.ServiceEntity;

import java.util.stream.Collectors;

public class ServiceMapper {

    private final ResourceMapper resourceMapper;

    public ServiceMapper(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    public ServiceDto toDto(ServiceEntity entity) {
        ServiceDto dto = new ServiceDto();
        dto.setId(entity.getId());
        dto.setCriticalText(entity.getCriticalText());
        dto.setResources(entity.getResources().stream()
                .map(resourceMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public ServiceEntity toEntity(ServiceDto dto) {
        ServiceEntity entity = new ServiceEntity();
        entity.setId(dto.getId());
        entity.setCriticalText(dto.getCriticalText());
        entity.setResources(dto.getResources().stream()
                .map(resourceMapper::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
