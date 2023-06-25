package rs.ac.bg.fon.is.server.handlers.root;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestMethod = exchange.getRequestMethod();

        if(requestMethod.equalsIgnoreCase("GET")) {
            String response = "Haha yeah";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
        if(!requestMethod.equalsIgnoreCase("GET")) {
            String response = "Fuck off and use GET";
            exchange.sendResponseHeaders(422, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
    }
}
