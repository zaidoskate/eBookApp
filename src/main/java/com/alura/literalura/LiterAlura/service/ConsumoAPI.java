package com.alura.literalura.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch(IOException ioException) {
            throw new RuntimeException(ioException);
        } catch(InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
        String json = response.body();
        return json;
    }
}
