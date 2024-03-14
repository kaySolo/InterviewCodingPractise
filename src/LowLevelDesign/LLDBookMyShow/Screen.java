package LowLevelDesign.LLDBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenId;
    List<Seat> allSeats = new ArrayList<>();

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(List<Seat> allSeats) {
        this.allSeats = allSeats;
    }
}
