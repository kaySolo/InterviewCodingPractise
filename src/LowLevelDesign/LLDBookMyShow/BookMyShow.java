package LowLevelDesign.LLDBookMyShow;

import LowLevelDesign.LLDBookMyShow.enums.City;
import LowLevelDesign.LLDBookMyShow.enums.SeatType;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    private final MovieController movieController;
    private final TheatreController theatreController;

    public BookMyShow(){
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public void demo(){
        initialize();
        try {
            createBooking(City.Bangalore, "BAAHUBALI");
            createBooking(City.Bangalore, "BAAHUBALI");
        }catch(Exception ex){
            System.out.println("Error occurred while booking: " + ex.getMessage());
        }
    }

    private void createBooking(City city, String movieName){
        List<Movie> allMovies = movieController.getAllMovies();
        Movie interestedMovie = null;

        //show all movies and user selects one
        for(Movie movie : allMovies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie = movie;
            }
        }

        // Display all shows for that movie
        Map<Theatre, List<Show>> allShowsForTheatreMap =
                theatreController.getAllShowForTheatre(interestedMovie, city);

        Map.Entry<Theatre, List<Show>> entry = allShowsForTheatreMap.entrySet().iterator().next();
        List<Show> allShowsForTheatre = entry.getValue();
        Show interestedShow = allShowsForTheatre.get(0);

        // take seat number input
        int seatNumber = 30;

        //booking
        List<Integer> allBookedSeats = interestedShow.getBookedSeatId();
        if(!allBookedSeats.contains(seatNumber)){
            // book seat
            allBookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat seat : interestedShow.getScreen().getAllSeats()){
                if(seat.getSeatId() == seatNumber){
                    myBookedSeats.add(seat);
                    break;
                }
            }

            booking.setBookedSeatIds(myBookedSeats);
            booking.setShow(interestedShow);
            booking.setBookingDate(Instant.now().toString());
        }else{
            // seat already booked
            throw new RuntimeException("Seat already booked. Try again!!");
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

    private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setAllScreens(createScreen());
        inoxTheatre.setCity(City.Bangalore);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getAllScreens().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getAllScreens().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setAllShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setAllScreens(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getAllScreens().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getAllScreens().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setAllShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setAllSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i <= 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 41; i <= 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.GOLD);
            seats.add(seat);
        }

        //71 to 100 : PLATINUM
        for (int i = 71; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatType(SeatType.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setDurationInMinutes(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setDurationInMinutes(180);


        //add movies against the cities
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(baahubali, City.Bangalore);
        movieController.addMovie(baahubali, City.Delhi);
    }

}
