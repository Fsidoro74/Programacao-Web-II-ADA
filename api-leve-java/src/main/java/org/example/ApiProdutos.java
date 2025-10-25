package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiProdutos {

    private static final String PRODUCTS_URL = "https://dummyjson.com/products";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(PRODUCTS_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Erro ao chamar API de produtos. Código: " + response.statusCode());
                System.out.println("Corpo: " + response.body());
                return;
            }

            String json = response.body();
            System.out.println("JSON Recebido (resumo):" );
            System.out.println(json.substring(0, Math.min(json.length(), 300)) + (json.length() > 300 ? "..." : ""));

            ObjectMapper mapper = new ObjectMapper();
            ProductsResponse productsResponse = mapper.readValue(json, ProductsResponse.class);

            if (productsResponse.getProducts() == null || productsResponse.getProducts().isEmpty()) {
                System.out.println("Nenhum produto encontrado na resposta.");
                return;
            }

            System.out.println("\nLista de Produtos (formato amigável):");
            productsResponse.getProducts().forEach(p -> {
                String linha = String.format("#%d %s — Preço: %.2f | Categoria: %s | Avaliação: %.1f | Estoque: %d",
                        p.getId(),
                        p.getTitle(),
                        p.getPrice(),
                        p.getCategory(),
                        p.getRating(),
                        p.getStock());
                System.out.println(linha);
            });
        } catch (Exception e) {
            System.out.println("Falha ao consultar ou processar a API de produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
