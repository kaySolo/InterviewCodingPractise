package LowLevelDesign.LLDSplitwise.group;

import LowLevelDesign.LLDSplitwise.expense.Expense;
import LowLevelDesign.LLDSplitwise.expense.ExpenseController;
import LowLevelDesign.LLDSplitwise.expense.ExpenseSplitType;
import LowLevelDesign.LLDSplitwise.expense.split.Split;
import LowLevelDesign.LLDSplitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String id;
    private String name;
    private List<User> memberList;
    private List<Expense> expenseList;
    private ExpenseController expenseController;

    public Group(){
        memberList = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User user){
        memberList.add(user);
    }

    public Expense createExpense(String expenseId, String description, double totalExpenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        Expense expense = expenseController.createExpense(expenseId, description, paidByUser,
                totalExpenseAmount, splitDetails, splitType);
        expenseList.add(expense);

        return expense;
    }

}
