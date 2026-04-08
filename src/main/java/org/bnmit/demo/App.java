package org.bnmit.demo;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static String greet() {
        return "Hello, Welcome to CI/CD Pipeline";
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // ✅ Frontend (HTML page)
        server.createContext("/", exchange -> {
            String html = "<html><body>"
                    + "<h1>CI/CD Pipeline Demo</h1>"
                    + "<a href='/greet'>Click to Call API</a>"
                    + "</body></html>";

            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, html.length());

            OutputStream os = exchange.getResponseBody();
            os.write(html.getBytes());
            os.close();
        });

        // ✅ API Endpoint
        server.createContext("/greet", exchange -> {
            String response = greet();

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server running at http://localhost:8080/");
    }
}
