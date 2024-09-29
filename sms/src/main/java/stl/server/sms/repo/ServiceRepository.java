package stl.server.sms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import stl.server.sms.entity.ServiceEntity;  // Updated to use ServiceEntity

import java.util.Optional;

public interface ServiceRepository extends MongoRepository<ServiceEntity, String> {
    Optional<ServiceEntity> findByName(String name);
}
