package stl.server.billing.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "bills")
public class Bill {

    @Id
    private String id;

    @NotNull
    private String userId;

    @NotNull
    private Date billDate;

    @NotNull
    private Date dueDate;

    @NotNull
    private BigDecimal totalAmount;

    private String status; // e.g., "paid", "unpaid", "overdue"

    public void setId(String id){
        this.id = id;
    }

    public void setUserId(String uid){
        this.userId = uid;
    }

    public void setBillDate( Date billDate){
        this.billDate = billDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    public void setTotalAmount(BigDecimal totalAmount ){
        this.totalAmount = totalAmount;
    }

    public void setStatus( String status){
        this.status = status;
    }

    public String getId() {
        return id;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public Date getBillDate() {
        return billDate;
    }
    
    public Date getDueDate() {
        return dueDate;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public String getStatus() {
        return status;
    }
    
}
