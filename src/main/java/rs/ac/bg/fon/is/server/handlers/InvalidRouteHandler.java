package rs.ac.bg.fon.is.server.handlers;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class InvalidRouteHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "Invalid route, sorry";
        exchange.sendResponseHeaders(404, response.length());
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes(StandardCharsets.UTF_8));
        outputStream.close();

    }
}
