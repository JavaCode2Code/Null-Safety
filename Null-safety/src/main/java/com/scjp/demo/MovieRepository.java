package com.scjp.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MovieRepository {

    private final List<Movie> movies = List.of(
            new Movie(1L, "Inception", 8.8),
            new Movie(2L, "Avatar 3", 4.0),
            new Movie(3L, "Interstellar", 9.0),
            new Movie(4L, "Border-3", 0.5)
           /* null,
            null*/
    );

    @Nullable
    public Movie findByName(String name) {
        return movies.stream()
                .filter(m -> m.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> findAll() {
        return movies.stream()
                .filter(Objects::nonNull)
                .toList();
    }


}