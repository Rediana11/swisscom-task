package com.project.swisscomtask.operation.impl;

import com.project.swisscomtask.dto.ServiceDto;
import com.project.swisscomtask.mapper.OwnerMapper;
import com.project.swisscomtask.mapper.ResourceMapper;
import com.project.swisscomtask.mapper.ServiceMapper;
import com.project.swisscomtask.model.ResourceEntity;
import com.project.swisscomtask.model.ServiceEntity;
import com.project.swisscomtask.util.EncryptionUtil;
import com.project.swisscomtask.operation.ServiceOperation;
import com.project.swisscomtask.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@EnableCaching
public class ServiceOperationImpl implements ServiceOperation {


    private final ServiceRepository serviceRepository;
    private final EncryptionUtil encryptionUtil;

    private final OwnerMapper ownerMapper = new OwnerMapper();
    private final ResourceMapper resourceMapper = new ResourceMapper(ownerMapper);
    private final ServiceMapper serviceMapper = new ServiceMapper(resourceMapper);


    @Autowired
    public ServiceOperationImpl(ServiceRepository serviceRepository, EncryptionUtil encryptionUtil) {
        this.serviceRepository = serviceRepository;
        this.encryptionUtil = encryptionUtil;
    }

    @Override
    public List<ServiceDto> getAllServices() {
        List<ServiceEntity> serviceEntities = serviceRepository.findAll();
        serviceEntities.forEach(this::encryptServiceCriticalText);
        return serviceEntities.stream().map(serviceMapper::toDto).collect(Collectors.toList());
    }

    private void encryptServiceCriticalText(ServiceEntity service) {
        service.setCriticalText(encryptionUtil.encrypt(service.getCriticalText()));
        service.getResources().forEach(this::encryptResourceCriticalText);
    }

    private void encryptResourceCriticalText(ResourceEntity resource) {
        resource.setCriticalText(encryptionUtil.encrypt(resource.getCriticalText()));
        resource.getOwners().forEach(owner -> owner.setCriticalText(encryptionUtil.encrypt(owner.getCriticalText())));
    }

    @CachePut(value = "service", key = "#result.id")
    @Override
    public ServiceDto createService(ServiceDto service) {
        log.info("Calling repository to create service...");
        ServiceEntity serviceEntity = serviceRepository.save(serviceMapper.toEntity(service));
        return serviceMapper.toDto(serviceEntity);
    }

    @CacheEvict(value = "service", key = "#id")
    @CachePut(value = "service", key = "#id")
    @Override
    public ServiceDto updateService(String id, ServiceDto updatedService) {
        if (!serviceRepository.existsById(id)) {
            throw new NotFoundException("Not valid Id: " + id);
        } else {
            log.info("Calling repository to update service...");
            ServiceEntity service = serviceRepository.save(serviceMapper.toEntity(updatedService));
            return serviceMapper.toDto(service);
        }
    }

    @Cacheable(value = "service", key = "#id")
    @Override
    public ServiceDto getServiceById(String id) {
        log.info("Calling repository to get service by Id...");
        ServiceEntity service = serviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Not valid Id: " + id));
        return serviceMapper.toDto(service);
    }

    @Override
    public String decryptText(String text) {
        return encryptionUtil.decrypt(text);
    }

}
