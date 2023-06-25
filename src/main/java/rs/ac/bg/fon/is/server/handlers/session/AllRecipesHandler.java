package rs.ac.bg.fon.is.server.handlers.session;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import rs.ac.bg.fon.is.server.handlers.IdHttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class AllRecipesHandler extends IdHttpHandler {


    public AllRecipesHandler(int id) {
        super(id);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestMethod = exchange.getRequestMethod();
        //TODO add recipes to the response
        if(requestMethod.equalsIgnoreCase("GET")) {
            String response = "Haha yeah welcome " +getId();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
        if(!requestMethod.equalsIgnoreCase("GET")) {
            String response = "Fuck off and use GET " + getId();
            exchange.sendResponseHeaders(422, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
    }
}