package com.project.swisscomtask.controller;

import com.project.swisscomtask.model.ServiceEntity;
import com.project.swisscomtask.repository.ServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/services")
public class ServiceController {

    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceEntity>> getAllServices() {
        List<ServiceEntity> services = new ArrayList<>(serviceRepository.findAll());
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
}
