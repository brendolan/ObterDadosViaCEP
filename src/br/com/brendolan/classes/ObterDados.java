package br.com.brendolan.classes;

import br.com.brendolan.exceptions.CEPNaoEncontrado;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObterDados {
    public Endereco buscar(String cep){
        String URL = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new CEPNaoEncontrado(cep);
            }

            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (CEPNaoEncontrado e) {
            throw new RuntimeException(e);
        }
    }
}
