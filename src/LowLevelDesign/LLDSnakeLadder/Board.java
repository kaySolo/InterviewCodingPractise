package LowLevelDesign.LLDSnakeLadder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell cells[][];

    public Board(int numberOfCells, int numberOfSnake, int numberOfLadder){
        cells = new Cell[numberOfCells][numberOfCells];
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                cells[i][j] = new Cell();
            }
        }
        addSnakeAndLadder(numberOfSnake, numberOfLadder);
    }

    private void addSnakeAndLadder(int numberOfSnake, int numberOfLadder){
        int snakeCount = numberOfSnake;
        int ladderCount = numberOfLadder;

        while(snakeCount > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if(start <= end){
                continue;
            }

            Jump snakeObj = new Jump(start, end);
            Cell cell = getCell(start);
            if(cell.getJump() != null){
                continue;
            }
            cell.setJump(snakeObj);
            snakeCount--;
        }

        while(ladderCount > 0){
            int start = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if(end <= start){
                continue;
            }

            Jump ladderObj = new Jump(start, end);
            Cell cell = getCell(start);
            if(cell.getJump() != null){
                continue;
            }
            cell.setJump(ladderObj);
            ladderCount--;
        }
    }

    public Cell getCell(int position){
        int row = position/10;
        int col = position%10;
        return cells[row][col];
    }
}
