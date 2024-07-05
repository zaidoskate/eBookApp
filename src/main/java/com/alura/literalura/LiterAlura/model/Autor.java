package com.alura.literalura.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(
        @JsonAlias("name") String name,
        @JsonAlias("birth_date") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear
) {
}
