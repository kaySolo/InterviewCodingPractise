package LowLevelDesign.LLDSplitwise.expense;

import LowLevelDesign.LLDSplitwise.expense.split.Split;
import LowLevelDesign.LLDSplitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String id;
    String description;
    double amount;
    User paidBy;
    List<Split> splitDetails = new ArrayList<>();
    ExpenseSplitType splitType;

    public Expense(String id, String description, double amount,
                   User paidBy, List<Split> splitDetails, ExpenseSplitType splitType) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitDetails.addAll(splitDetails);
        this.splitType = splitType;
    }
}
