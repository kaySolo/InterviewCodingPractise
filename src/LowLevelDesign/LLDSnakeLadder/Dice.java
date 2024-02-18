package LowLevelDesign.LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private int min;
    private int max;

    public Dice(int diceCount, int min, int max){
        this.diceCount = diceCount;
        this.min = min;
        this.max = max;
    }

    public int rollDice(){
        int totalSum = 0;
        int remainingDiceRoll = diceCount;

        while(remainingDiceRoll > 0){
            int diceRollValue = ThreadLocalRandom.current().nextInt(min, max+1);
            totalSum += diceRollValue;
            remainingDiceRoll--;
        }

        return totalSum;
    }
}
