package stl.server.billing.controller;

import stl.server.billing.entity.Bill;
import stl.server.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/create")
    public ResponseEntity<Bill> createBill(@Validated @RequestBody Bill bill) {
        Bill createdBill = billingService.createBill(bill);
        return ResponseEntity.ok(createdBill);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bill>> getUserBills(@PathVariable String userId) {
        List<Bill> bills = billingService.getBillsByUserId(userId);
        return ResponseEntity.ok(bills);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Optional<Bill>> getBillById(@PathVariable String billId) {
        Optional<Bill> bill = billingService.getBillById(billId);
        return ResponseEntity.ok(bill);
    }

    @PutMapping("/{billId}/status")
    public ResponseEntity<Bill> updateBillStatus(@PathVariable String billId, @RequestParam String status) {
        Bill updatedBill = billingService.updateBillStatus(billId, status);
        if (updatedBill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBill);
    }
}
