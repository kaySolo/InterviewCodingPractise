package LowLevelDesign.LLDSplitwise.expense;

import LowLevelDesign.LLDSplitwise.expense.split.EqualExpenseSplit;
import LowLevelDesign.LLDSplitwise.expense.split.ExpenseSplit;
import LowLevelDesign.LLDSplitwise.expense.split.PercentageExpenseSplit;
import LowLevelDesign.LLDSplitwise.expense.split.UnequalExpenseSplit;

public class ExpenseSplitFactory {
    public static ExpenseSplit getExpenseSplit(ExpenseSplitType splitType){
        switch(splitType){
            case EQUAL: return new EqualExpenseSplit();
            case UNEQUAL: return new UnequalExpenseSplit();
            case PERCENTAGE: return new PercentageExpenseSplit();
            default: return null;
        }
    }

}
