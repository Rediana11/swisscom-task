package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.ResourceDto;
import com.project.swisscomtask.model.ResourceEntity;

import java.util.stream.Collectors;

public class ResourceMapper {

    private final OwnerMapper ownerMapper;

    public ResourceMapper(OwnerMapper ownerMapper) {
        this.ownerMapper = ownerMapper;
    }

    public ResourceDto toDto(ResourceEntity entity) {
        ResourceDto dto = new ResourceDto();
        dto.setCriticalText(entity.getCriticalText());
        dto.setOwners(entity.getOwners().stream()
                .map(ownerMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public ResourceEntity toEntity(ResourceDto dto) {
        ResourceEntity entity = new ResourceEntity();
        entity.setCriticalText(dto.getCriticalText());
        entity.setOwners(dto.getOwners().stream()
                .map(ownerMapper::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
