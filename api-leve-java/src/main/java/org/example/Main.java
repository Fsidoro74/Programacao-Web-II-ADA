package org.example;

import io.github.marceltanuri.frameworks.restam3.Ami;

public class Main {
    public static void main(String[] args) {

        HelloController helloController = new HelloController();

        // 1. Inicia o servidor
        Ami.start(8080);

        // 2. Define as rotas
        Ami.get("/hello", helloController::sayHello);
        Ami.get("/teste", helloController::pageTest);

        // 3. Imprime mensagens de ajuda
        System.out.println("==================================================");
        System.out.println(">>> Servidor rodando! Acesse as URLs no seu navegador:");
        System.out.println(">>> http://localhost:8080/hello");
        System.out.println(">>> http://localhost:8080/teste");
        System.out.println("==================================================");

        // 4. ADICIONE ESTA LINHA PARA MANTER O SERVIDOR VIVO:
        try { Thread.sleep(Long.MAX_VALUE); } catch (Exception e) {}
    }
}