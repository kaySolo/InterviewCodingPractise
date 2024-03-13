package LowLevelDesign.LLDSplitwise.expense;

import LowLevelDesign.LLDSplitwise.balanceSheet.BalanceSheetController;
import LowLevelDesign.LLDSplitwise.expense.split.ExpenseSplit;
import LowLevelDesign.LLDSplitwise.expense.split.Split;
import LowLevelDesign.LLDSplitwise.user.User;

import java.util.List;

public class ExpenseController {

    private BalanceSheetController balanceSheetController;
    public ExpenseController(){
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, User paidByUser,
                              double totalExpenseAmount, List<Split> splitDetails, ExpenseSplitType splitType){
        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplit(splitType);
        expenseSplit.validateExpense(splitDetails, totalExpenseAmount);

        Expense expense = new Expense(expenseId, description, totalExpenseAmount,
                paidByUser, splitDetails, splitType);

        balanceSheetController.updateUserBalanceSheet(paidByUser, splitDetails, totalExpenseAmount);

        return expense;
    }
}
