package com.project.swisscomtask.operation.impl;

import com.project.swisscomtask.dto.ServiceDto;
import com.project.swisscomtask.mapper.OwnerMapper;
import com.project.swisscomtask.mapper.ResourceMapper;
import com.project.swisscomtask.mapper.ServiceMapper;
import com.project.swisscomtask.mapper.impl.OwnerMapperImpl;
import com.project.swisscomtask.mapper.impl.ResourceMapperImpl;
import com.project.swisscomtask.mapper.impl.ServiceMapperImpl;
import com.project.swisscomtask.model.ServiceEntity;
import com.project.swisscomtask.operation.ServiceOperation;
import com.project.swisscomtask.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOperationImpl implements ServiceOperation {


    private final ServiceRepository serviceRepository;

    OwnerMapper ownerMapper = new OwnerMapperImpl();
    ResourceMapper resourceMapper = new ResourceMapperImpl(ownerMapper);
    ServiceMapper serviceMapper = new ServiceMapperImpl(resourceMapper);


    @Autowired
    public ServiceOperationImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDto> getAllServices() {
        List<ServiceEntity> serviceDtos = serviceRepository.findAll();
        return serviceDtos.stream().map(e -> serviceMapper.toDto(e)).collect(Collectors.toList());
    }

    @Override
    public ServiceDto createService(ServiceDto service) {
        ServiceEntity serviceEntity = serviceRepository.save(serviceMapper.toEntity(service));
        return serviceMapper.toDto(serviceEntity);
    }

    @Override
    public ServiceDto updateService(String id, ServiceDto updatedService) {
        if (serviceRepository.existsById(id)) {
            ServiceEntity service = serviceRepository.save(serviceMapper.toEntity(updatedService));
            return serviceMapper.toDto(service);
        } else {
            throw new NotFoundException("Not valid Id: " + id);
        }
    }

    @Override
    public ServiceDto getServiceById(String id) {
        ServiceEntity service = serviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Not valid Id: " + id));
        return serviceMapper.toDto(service);
    }

}
