package LowLevelDesign.LLDSplitwise.balanceSheet;

import LowLevelDesign.LLDSplitwise.user.User;

import java.util.HashMap;

public class UserExpenseBalanceSheet {

    private HashMap<String, Balance> friendsBalanceMap;
    private double totalExpense;
    private double totalPaid;
    private double totalOwe;
    private double totalGetBack;

    public UserExpenseBalanceSheet(){
        this.friendsBalanceMap = new HashMap<>();
        this.totalExpense = 0;
        this.totalPaid = 0;
        this.totalOwe = 0;
        this.totalGetBack = 0;
    }

    public HashMap<String, Balance> getFriendsBalanceMap() {
        return friendsBalanceMap;
    }

    public void setFriendsBalanceMap(HashMap<String, Balance> friendsBalanceMap) {
        this.friendsBalanceMap = friendsBalanceMap;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
