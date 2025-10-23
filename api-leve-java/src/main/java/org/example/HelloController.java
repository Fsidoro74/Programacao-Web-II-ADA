package org.example;

// Estas classes são do framework 'ami'.
// Se os nomes forem outros, ajuste aqui.
import io.github.marceltanuri.frameworks.restam3.Request;
import io.github.marceltanuri.frameworks.restam3.Response;

/**
 * Esta é a sua classe "Controladora".
 */
public class HelloController {

    /**
     * Este é um "método" que vai lidar com a URL /hello
     */
    public String sayHello(Request req, Response res) {
        // O que você retornar aqui será a resposta da API
        return "Olá, mundo! Esta é minha primeira API REST!";
    }

    /**
     * Este é outro "método" que vai lidar com a URL /teste
     */
    public String pageTest(Request req, Response res) {
        return "Esta é a página de teste. Funcionou!";
    }
}