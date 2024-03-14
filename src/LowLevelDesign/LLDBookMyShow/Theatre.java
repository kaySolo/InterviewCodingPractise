package LowLevelDesign.LLDBookMyShow;

import LowLevelDesign.LLDBookMyShow.enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int theatreId;
    String address;
    City city;
    List<Screen> allScreens = new ArrayList<>();
    List<Show> allShows = new ArrayList<>();

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getAllScreens() {
        return allScreens;
    }

    public void setAllScreens(List<Screen> allScreens) {
        this.allScreens = allScreens;
    }

    public List<Show> getAllShows() {
        return allShows;
    }

    public void setAllShows(List<Show> allShows) {
        this.allShows = allShows;
    }
}
