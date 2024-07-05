package com.alura.literalura.LiterAlura.repositorio;

import com.alura.literalura.LiterAlura.domain.LibroEntity;
import com.alura.literalura.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

    @Query("SELECT l FROM LibroEntity l WHERE l.idioma >= :idioma")
    List<LibroEntity> findByLanguage(String idioma);

}
