package stl.server.authentication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import stl.server.authentication.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
