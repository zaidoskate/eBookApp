package com.alura.literalura.LiterAlura.domain;

import com.alura.literalura.LiterAlura.model.Autor;
import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;

    @OneToOne
    @JoinTable(
            name = "Libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private LibroEntity libros;


    public AutorEntity() {

    }

    public AutorEntity(Autor autor) {
        this.nombre = autor.name();

        if (autor.birthYear() == null)
            this.fechaNacimiento = 1980;
        else
            this.fechaNacimiento = autor.birthYear();

        if (autor.deathYear() == null)
            this.fechaMuerte = 3022;
        else
            this.fechaMuerte = autor.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaMuerte;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaMuerte = fechaFallecimiento;
    }


    @Override
    public String toString() {
        return "AutorEntity [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
                + ", fechaFallecimiento=" + fechaMuerte + ", libro="  + "]";
    }

    public LibroEntity getLibros() {
        return libros;
    }

    public void setLibros(LibroEntity libros) {
        this.libros = libros;
    }
}
