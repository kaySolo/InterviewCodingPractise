package LowLevelDesign.LLDBookMyShow;

import LowLevelDesign.LLDBookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    List<Theatre> allTheatres = new ArrayList<>();
    HashMap<City, List<Theatre>> cityVsTheatre = new HashMap<>();

    public void addTheatre(Theatre theatre, City city){
        this.allTheatres.add(theatre);

        //get theatre list for city
        List<Theatre> theatresForCity = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatresForCity.add(theatre);
        cityVsTheatre.put(city, theatresForCity);
    }

    public Map<Theatre, List<Show>> getAllShowForTheatre(Movie interestedMovie, City city){
        Map<Theatre, List<Show>> theatreVsShowMap = new HashMap<>();
        List<Theatre> theatresForCity = cityVsTheatre.get(city);

        for(Theatre theatre : theatresForCity){
            List<Show> showsForMovie = new ArrayList<>();
            for(Show show : theatre.getAllShows()){
                if(show.getMovie().getMovieName().equals(interestedMovie.getMovieName())){
                    showsForMovie.add(show);
                }
            }
            if(!showsForMovie.isEmpty()){
                theatreVsShowMap.put(theatre, showsForMovie);
            }
        }
        return theatreVsShowMap;
    }
}
