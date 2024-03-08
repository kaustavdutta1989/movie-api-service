package com.riko.movie.service;

import com.riko.movie.model.Genre;
import com.riko.movie.model.dto.GenreMinDTO;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    Genre createGenre(GenreMinDTO genreMinDTO);
    Genre getGenreById(Long id);
}
