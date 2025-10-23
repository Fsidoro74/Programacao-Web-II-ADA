package io.github.marceltanuri.frameworks.restam3;

/**
 * Minimal stub of the Ami framework to allow the project to compile.
 * This is NOT a production-ready server; it only provides the API surface
 * used by this project (start + get with a handler accepting Request/Response).
 */
public final class Ami {

    private Ami() {}

    public static void start(int port) {
        System.out.println("[Ami STUB] Starting server on port " + port + " (no-op)");
    }

    public static void get(String path, Handler handler) {
        // In the real framework this would register the route.
        // Here we only log to indicate the project wired correctly.
        System.out.println("[Ami STUB] Registered GET route: " + path);
    }

    @FunctionalInterface
    public interface Handler {
        String handle(Request req, Response res);
    }
}
