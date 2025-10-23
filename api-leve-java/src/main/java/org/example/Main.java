package org.example;

// Importa a classe principal do framework
import io.github.marcelotaunuri.frameworks.restam3.Ami;

public class Main {
    public static void main(String[] args) {

        // 1. Cria uma "instância" (um objeto) do seu controller
        HelloController helloController = new HelloController();

        // 2. Inicia o servidor do framework 'ami'
        // A porta 8080 é o padrão para desenvolvimento
        Ami.start(port: 8080);

        // 3. Define as "rotas" (endpoints) da sua API.
        // Isso "conecta" uma URL a um método do seu controller.

        // Conecta a URL "/hello" ao método "sayHello"
        Ami.get(path: "/hello", helloController::sayHello);

        // Conecta a URL "/teste" ao método "pageTest"
        Ami.get(path: "/teste", helloController::pageTest);


        // Mensagem para você saber que o servidor iniciou
        System.out.println("==================================================");
        System.out.println(">>> Servidor rodando! Acesse as URLs no seu navegador:");
        System.out.println(">>> http://localhost:8080/hello");
        System.out.println(">>> http://localhost:8080/teste");
        System.out.println("==================================================");

        // ADICIONE ESTA LINHA AQUI NO FINAL:
        // Trava a thread principal para o servidor não morrer
        try { Thread.sleep(Long.MAX_VALUE); } catch (Exception e) {}
    }
}