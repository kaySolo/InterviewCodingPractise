package LowLevelDesign.LLDBookMyShow;

import LowLevelDesign.LLDBookMyShow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {
    List<Movie> allMovies = new ArrayList<>();
    HashMap<City, List<Movie>> cityVsMovie = new HashMap<>();

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public HashMap<City, List<Movie>> getCityVsMovie() {
        return cityVsMovie;
    }

    public void setCityVsMovie(HashMap<City, List<Movie>> cityVsMovie) {
        this.cityVsMovie = cityVsMovie;
    }

    public void addMovie(Movie movie, City city){
        this.allMovies.add(movie);

        //get movies for city
        List<Movie> moviesForCity = cityVsMovie.getOrDefault(city, new ArrayList<>());
        moviesForCity.add(movie);
        cityVsMovie.put(city, moviesForCity);
    }

    public Movie getMovieByName(String movieName){
        for(Movie movie : allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }
}
