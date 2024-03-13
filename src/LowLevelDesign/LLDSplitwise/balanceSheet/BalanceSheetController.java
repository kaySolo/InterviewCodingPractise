package LowLevelDesign.LLDSplitwise.balanceSheet;

import LowLevelDesign.LLDSplitwise.expense.split.Split;
import LowLevelDesign.LLDSplitwise.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateUserBalanceSheet(User paidByUser, List<Split> splitDetails, double totalExpenseAmount){
        UserExpenseBalanceSheet paidUserBalanceSheet = paidByUser.getBalanceSheet();
        paidUserBalanceSheet.setTotalPaid(paidUserBalanceSheet.getTotalPaid() + totalExpenseAmount);

        for(Split split: splitDetails){
            User oweUser = split.getUser();
            double oweAmount = split.getAmountOwe();

            if(oweUser.getId().equals(paidByUser.getId())){
                // owe user is paid user -> update total expense
                paidUserBalanceSheet.setTotalExpense(paidUserBalanceSheet.getTotalExpense() + oweAmount);
            }else{
                //update paid user balance sheet
                paidUserBalanceSheet.setTotalGetBack(paidUserBalanceSheet.getTotalGetBack() + oweAmount);

                Balance oweUserBalance;
                if(paidUserBalanceSheet.getFriendsBalanceMap().containsKey(oweUser.getId())){
                    oweUserBalance = paidUserBalanceSheet.getFriendsBalanceMap().get(oweUser.getId());
                }else{
                    oweUserBalance = new Balance();
                    paidUserBalanceSheet.getFriendsBalanceMap().put(oweUser.getId(), oweUserBalance);
                }

                oweUserBalance.setAmountGetBack(oweUserBalance.getAmountGetBack() + oweAmount);

                // update owe user balance sheet
                UserExpenseBalanceSheet oweUserBalanceSheet = oweUser.getBalanceSheet();
                oweUserBalanceSheet.setTotalOwe(oweUserBalanceSheet.getTotalOwe() + oweAmount);
                oweUserBalanceSheet.setTotalExpense(oweUserBalanceSheet.getTotalExpense() + oweAmount);

                Balance paidUserBalance;
                if(oweUserBalanceSheet.getFriendsBalanceMap().containsKey(paidByUser.getId())){
                    paidUserBalance = oweUserBalanceSheet.getFriendsBalanceMap().get(paidByUser.getId());
                }else{
                    paidUserBalance = new Balance();
                    oweUserBalanceSheet.getFriendsBalanceMap().put(paidByUser.getId(), paidUserBalance);
                }

                paidUserBalance.setAmountOwe(paidUserBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPaid());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getFriendsBalanceMap().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }


}
