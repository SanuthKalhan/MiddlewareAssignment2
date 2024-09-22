package stl.server.billing.service;

import stl.server.billing.entity.Bill;
import stl.server.billing.repo.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    public Bill createBill(Bill bill) {
        bill.setBillDate(new Date());
        bill.setStatus("unpaid");
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByUserId(String userId) {
        return billRepository.findByUserId(userId);
    }

    public Optional<Bill> getBillById(String billId) {
        return billRepository.findById(billId);
    }

    public Bill updateBillStatus(String billId, String status) {
        Optional<Bill> bill = billRepository.findById(billId);
        if (bill.isPresent()) {
            Bill updatedBill = bill.get();
            updatedBill.setStatus(status);
            return billRepository.save(updatedBill);
        }
        return null;
    }
}
