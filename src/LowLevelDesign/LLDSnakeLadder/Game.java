package LowLevelDesign.LLDSnakeLadder;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(2, 1, 6);
        players = new ArrayDeque<>();

        addPlayers(2);
    }

    private void addPlayers(int numberOfPlayers){
        this.players = new ArrayDeque<>();

        for(int i=0;i<numberOfPlayers;i++){
            Player player = new Player(i+1, "Player-" + (i+1), 0);
            players.addLast(player);
        }
    }

    public void startGame(){
        while(winner == null){
            // check player turn
            Player currentPlayer = findPlayerTurn();
            System.out.println("Player turn : " + currentPlayer.getPlayerId() + " name: " + currentPlayer.getPlayerName()
                    + " position: " + currentPlayer.getCurrentPos());
            System.out.println("Press enter to roll dice.");
            // dice roll value
            int diceValue = dice.rollDice();

            int playerNewPosition = currentPlayer.getCurrentPos() + diceValue;
            playerNewPosition = checkForJump(playerNewPosition);
            if(playerNewPosition > board.cells.length*board.cells.length-1){
                System.out.println("Invalid turn for " + currentPlayer.getPlayerName());
                continue;
            }
            currentPlayer.setCurrentPos(playerNewPosition);

            //check for winner
            if(playerNewPosition == board.cells.length*board.cells.length-1){
                winner = currentPlayer;
                System.out.println("Winner is : " + winner.getPlayerName());
            }
        }
    }

    private int checkForJump(int position) {
        if(position > board.cells.length*board.cells.length-1){
            return position;
        }

        Cell cell = board.getCell(position);

        if(cell.getJump() != null && cell.getJump().getStart() == position){
            String jumpBy = cell.getJump().getStart() > cell.getJump().getEnd() ? "Snake" : "Ladder";
            System.out.println("Jump done by : " + jumpBy);
            return cell.getJump().getEnd();
        }
        return position;
    }

    private Player findPlayerTurn(){
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }

}
