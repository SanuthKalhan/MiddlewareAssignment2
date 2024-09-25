package stl.server.sms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import stl.server.sms.entity.Service;

import java.util.Optional;

public interface ServiceRepository extends MongoRepository<Service, String> {
    Optional<Service> findByName(String name);
}