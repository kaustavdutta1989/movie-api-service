package com.riko.movie.service.implementation;

import com.riko.movie.model.Genre;
import com.riko.movie.model.dto.GenreMinDTO;
import com.riko.movie.repo.GenreRepository;
import com.riko.movie.service.GenreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre createGenre(GenreMinDTO genreMinDTO) {
        return genreRepository.save(Genre.builder()
                .name(genreMinDTO.getName())
                .build());
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("genre not found with id: " + id));
    }
}
