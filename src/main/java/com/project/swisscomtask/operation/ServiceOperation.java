package com.project.swisscomtask.operation;

import com.project.swisscomtask.dto.ServiceDto;

import java.util.List;

public interface ServiceOperation {

    List<ServiceDto> getAllServices();

    ServiceDto createService(ServiceDto serviceEntity);

    ServiceDto updateService(String id, ServiceDto updatedServiceEntity);

    ServiceDto getServiceById(String id);
}
