package io.github.marceltanuri.frameworks.restam3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Minimal working HTTP server to support start() and get() routes.
 */
public final class Ami {

    private static HttpServer server;
    private static final Map<String, Handler> getRoutes = new ConcurrentHashMap<>();

    private Ami() {}

    public static void start(int port) {
        if (server != null) {
            System.out.println("[Ami] Server already started on port " + port);
            return;
        }
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", Ami::handleExchange);
            server.setExecutor(null); // default executor
            server.start();
            System.out.println("[Ami] Starting server on port " + port);
        } catch (IOException e) {
            throw new RuntimeException("[Ami] Failed to start server on port " + port, e);
        }
    }

    private static void handleExchange(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        if (!"GET".equalsIgnoreCase(method)) {
            send(exchange, 405, "Method Not Allowed");
            return;
        }

        Handler handler = getRoutes.get(path);
        if (handler == null) {
            send(exchange, 404, "Not Found");
            return;
        }

        Request req = new Request();
        Response res = new Response();

        String result;
        try {
            result = handler.handle(req, res);
            if (result == null) result = "";
        } catch (Exception ex) {
            ex.printStackTrace();
            send(exchange, 500, "Internal Server Error");
            return;
        }

        send(exchange, 200, result);
    }

    private static void send(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    public static void get(String path, Handler handler) {
        getRoutes.put(path, handler);
        System.out.println("[Ami] Registered GET route: " + path);
    }

    @FunctionalInterface
    public interface Handler {
        String handle(Request req, Response res);
    }
}
