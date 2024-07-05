package com.alura.literalura.LiterAlura.domain;

import com.alura.literalura.LiterAlura.model.Autor;
import com.alura.literalura.LiterAlura.model.Libro;
import jakarta.persistence.*;

@Entity
@Table(name = "Libro")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Integer descargas;
    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AutorEntity autor;

    public LibroEntity(){}

    public LibroEntity(Libro libro) {
        this.titulo = libro.title();
        this.descargas = libro.download();
        if(!libro.languages().isEmpty()) {
            this.idioma = libro.languages().getFirst();
        }
        if(!libro.autores().isEmpty()) {
            for(Autor autor : libro.autores()) {
                this.autor = new AutorEntity(autor);
                break;
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public AutorEntity getAutor() {
        return autor;
    }

    public void setAutor(AutorEntity autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "LibroEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", descargas=" + descargas +
                ", autor=" + autor +
                '}';
    }
}
