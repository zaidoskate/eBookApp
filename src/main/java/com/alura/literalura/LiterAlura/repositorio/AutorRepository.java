package com.alura.literalura.LiterAlura.repositorio;

import java.util.List;
import com.alura.literalura.LiterAlura.domain.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

    @Query("SELECT a FROM AutorEntity a WHERE :anio BETWEEN a.fechaNacimiento AND a.fechaMuerte")
    List<AutorEntity> findByYear(int anio);
}
