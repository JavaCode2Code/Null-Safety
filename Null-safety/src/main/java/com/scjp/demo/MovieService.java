package com.scjp.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public String getMovieDetails(String movieName) {

        Movie movie = repository.findByName(movieName);

        if (movie == null) {
            return "Movie not found!";
        }
        else{
            return """
                    🎬 Movie Details!
                    Movie: %s
                    Rating: %s
                    Enjoy your show! 🍿
                    """.formatted(movie.name().toUpperCase(),
                    movie.rating());
        }

    }

    public String bookMovie(String movieName,@Nullable String promoCode ) {
        //assume we fetch movie details from DB
        sendBookingConfirmation(movieName);

       if(promoCode!=null) {
           applyPromoCode(promoCode);
       }

        return "Booking confirmed and notification sent for movie: " + movieName;
    }

    public List<String> getMovieNames() {
        return repository.findAll().stream()
                .map(movie -> movie.name())
                .toList();
    }
    private void applyPromoCode(String promoCode) {
        System.out.println("Applying promo code: " + promoCode.toUpperCase());
    }

    private void sendBookingConfirmation(String movieName) {
        System.out.println("Booking confirmation sent for movie: " + movieName);
    }
}