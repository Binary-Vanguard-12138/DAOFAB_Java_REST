package com.demo.daofab.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Model for parent transaction
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ParentTransaction {
    @Id
    private int id;
    private String sender;
    private String receiver;
    private int totalAmount;
    private ArrayList<ChildTransaction> childTransactions = new ArrayList<ChildTransaction>();

    public ParentTransaction(int _id, String _sender, String _receiver, int _total_amount) {
        this.id = _id;
        this.sender = _sender;
        this.receiver = _receiver;
        this.totalAmount = _total_amount;
    }

    public void addChildTransaction(ChildTransaction childTransaction) {
        if (null != childTransaction) {
            this.childTransactions.add(childTransaction);
        }
    }

    public int getTotalPaidAmount() {
        int totalPaidAmount = 0;
        int iChild;
        for (iChild = 0; iChild < childTransactions.size(); iChild ++) {
            totalPaidAmount += childTransactions.get(iChild).getPaidAmount();
        }
        return totalPaidAmount;
    }
}
