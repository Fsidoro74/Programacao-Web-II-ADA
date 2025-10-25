package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Esta classe é a nossa "especialista" em acessar APIs.
 * A lógica de como buscar os dados fica toda aqui dentro.
 */
public class ApiClient {

    // O Cliente HTTP é criado uma vez e pode ser reutilizado
    private HttpClient client;

    // Construtor: é executado quando criamos um "new ApiClient()"
    public ApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * Busca um produto específico na DummyJSON API pelo seu ID.
     * @param productId O ID do produto que queremos buscar (ex: 1, 2, 3...)
     * @return Uma String contendo o JSON do produto, ou uma mensagem de erro.
     */
    public String getProductById(int productId) {

        String urlParaBuscar = "https://dummyjson.com/products/" + productId;

        // 1. Cria a Requisição (Request)
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(urlParaBuscar))
                                         .GET()
                                         .build();

        try {
            // 2. Envia a Requisição e Recebe a Resposta (Response)
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

            // 3. Retorna o corpo (body) da resposta
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "!!! Erro ao buscar o produto: " + e.getMessage();
        }
    }

    // Você poderia adicionar outros métodos aqui:
    // public String getAllProducts() { ... }
    // public String getUserByUsername(String name) { ... }
}