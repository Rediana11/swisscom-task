package com.project.swisscomtask.controller;

import com.project.swisscomtask.dto.ServiceDto;
import com.project.swisscomtask.operation.ServiceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ServiceURL.BASE)
public class ServiceController {

    private final ServiceOperation serviceOperation;

    @Autowired
    public ServiceController(ServiceOperation serviceOperation) {
        this.serviceOperation = serviceOperation;
    }

    @GetMapping(ServiceURL.DATA)
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        List<ServiceDto> services = serviceOperation.getAllServices();
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceEntity) {
        return ResponseEntity.ok().body(serviceOperation.createService(serviceEntity));
    }

    @PutMapping(ServiceURL.SERVICE_ID)
    public ResponseEntity<ServiceDto> updateService(@PathVariable String id, @RequestBody ServiceDto updatedServiceEntity) {
        return ResponseEntity.ok().body(serviceOperation.updateService(id, updatedServiceEntity));
    }

    @GetMapping(ServiceURL.SERVICE_ID)
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable String id) {
        return ResponseEntity.ok().body(serviceOperation.getServiceById(id));
    }

    @PostMapping(ServiceURL.TEXT)
    public ResponseEntity<String> decryptText(@PathVariable String text) {
        return ResponseEntity.ok().body(serviceOperation.decryptText(text));
    }

}
