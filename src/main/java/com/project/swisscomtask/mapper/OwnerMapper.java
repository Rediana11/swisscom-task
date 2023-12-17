package com.project.swisscomtask.mapper;

import com.project.swisscomtask.dto.OwnerDto;
import com.project.swisscomtask.model.OwnerEntity;

public class OwnerMapper {

    public OwnerDto toDto(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();
        dto.setCriticalText(entity.getCriticalText());
        dto.setName(entity.getName());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setLevel(entity.getLevel());
        return dto;
    }

    public OwnerEntity toEntity(OwnerDto dto) {
        OwnerEntity entity = new OwnerEntity();
        entity.setCriticalText(dto.getCriticalText());
        entity.setName(dto.getName());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setLevel(dto.getLevel());
        return entity;
    }

}
