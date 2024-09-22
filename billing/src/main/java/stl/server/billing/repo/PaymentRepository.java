package stl.server.billing.repo;

import stl.server.billing.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByTransactionId(String transactionId);
}
