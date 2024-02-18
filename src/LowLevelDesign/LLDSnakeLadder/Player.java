package LowLevelDesign.LLDSnakeLadder;

public class Player {
    private int playerId;
    private String playerName;
    private int currentPos;

    public Player(int playerId, String playerName, int currentPos) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.currentPos = currentPos;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}
