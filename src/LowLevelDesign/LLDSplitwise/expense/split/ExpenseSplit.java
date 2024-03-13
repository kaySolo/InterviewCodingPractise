package LowLevelDesign.LLDSplitwise.expense.split;

import java.util.List;

public interface ExpenseSplit {
    public void validateExpense(List<Split> splitList, double amount);
}
