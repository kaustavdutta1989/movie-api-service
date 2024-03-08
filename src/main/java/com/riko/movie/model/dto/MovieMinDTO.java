package com.riko.movie.model.dto;

import com.riko.movie.model.Genre;
import com.riko.movie.model.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieMinDTO {
    private String name;
    private Long genreId;
    private Long languageId;
}
