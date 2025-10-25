package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner; // Para ler a entrada do usuário
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClienteViaCEP {

    // O Cliente HTTP, pode ser estático e reutilizado
    private static HttpClient client = HttpClient.newHttpClient();

    /**
     * Busca um endereço na API ViaCEP.
     * @param cep O CEP para buscar (ex: "01001000")
     * @return Uma String com o JSON da resposta
     */
    public String buscaEnderecoPorCep(String cep) {

        // Remove hífens ou pontos do CEP, caso o usuário digite
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        String urlParaBuscar = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(urlParaBuscar))
                                         .GET()
                                         .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                return "Erro: CEP não encontrado ou API fora do ar. Código: " + response.statusCode();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "!!! Erro crítico ao chamar a API: " + e.getMessage();
        }
    }

    /**
     * Este é o método main para TESTAR esta classe
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um CEP:");
        String cep = scanner.nextLine();

        ClienteViaCEP cliente = new ClienteViaCEP();
        String json = cliente.buscaEnderecoPorCep(cep);

        System.out.println("JSON Recebido:");
        System.out.println(json);

        try {
            ObjectMapper mapper = new ObjectMapper();
            Endereco endereco = mapper.readValue(json, Endereco.class);

            System.out.println("Exibição Amigável (do Objeto Java):");
            System.out.println("Rua: " + endereco.getLogradouro());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("Cidade: " + endereco.getLocalidade());
            System.out.println("Estado: " + endereco.getUf());
        } catch (Exception e) {
            System.out.println("Não foi possível converter o JSON para Endereco: " + e.getMessage());
        }

        scanner.close();
    }
}