package LowLevelDesign.LLDSplitwise.user;

import LowLevelDesign.LLDSplitwise.balanceSheet.UserExpenseBalanceSheet;

public class User {

    private String id;
    private String name;
    private UserExpenseBalanceSheet balanceSheet;

    public User(String id, String name){
        this.id = id;
        this.name = name;
        balanceSheet = new UserExpenseBalanceSheet();
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

    public UserExpenseBalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(UserExpenseBalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
