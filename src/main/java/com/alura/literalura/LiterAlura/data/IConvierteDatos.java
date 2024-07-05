package com.alura.literalura.LiterAlura.data;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
