package stl.server.billing.repo;

import stl.server.billing.entity.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByUserId(String userId);
}
