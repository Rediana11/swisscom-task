package com.project.swisscomtask.mapper.impl;

import com.project.swisscomtask.dto.OwnerDto;
import com.project.swisscomtask.mapper.OwnerMapper;
import com.project.swisscomtask.model.OwnerEntity;

public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnerDto toDto(OwnerEntity entity) {
        OwnerDto dto = new OwnerDto();
        dto.setCriticalText(entity.getCriticalText());
        dto.setName(entity.getName());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setLevel(entity.getLevel());
        return dto;
    }

    @Override
    public OwnerEntity toEntity(OwnerDto dto) {
        OwnerEntity entity = new OwnerEntity();
        entity.setCriticalText(dto.getCriticalText());
        entity.setName(dto.getName());
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setLevel(dto.getLevel());
        return entity;
    }

}
