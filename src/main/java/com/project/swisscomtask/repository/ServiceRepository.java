package com.project.swisscomtask.repository;

import com.project.swisscomtask.model.ServiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ServiceRepository extends MongoRepository<ServiceEntity, String> {

}
