package org.example;

/**
 * Esta classe é SÓ PARA TESTAR o nosso ApiClient.
 * Ela tem seu próprio método main().
 */
public class TestClient {

    public static void main(String[] args) {

        // 1. Cria o nosso cliente especialista
        ApiClient apiClient = new ApiClient();

        System.out.println("Buscando o produto com ID 1...");

        // 2. Pede para o cliente buscar o produto 1
        String produto1 = apiClient.getProductById(1);

        // 3. Imprime o resultado
        System.out.println("=========================================");
        System.out.println("Produto 1 (JSON):");
        System.out.println(produto1);
        System.out.println("=========================================");


        // --- Vamos testar com outro produto ---
        System.out.println("\nBuscando o produto com ID 5...");

        // 2. Pede para o cliente buscar o produto 5
        String produto5 = apiClient.getProductById(5);

        // 3. Imprime o resultado
        System.out.println("=========================================");
        System.out.println("Produto 5 (JSON):");
        System.out.println(produto5);
        System.out.println("=========================================");
    }
}