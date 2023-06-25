package rs.ac.bg.fon.is.server.handlers.root;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import rs.ac.bg.fon.is.server.APIServer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Handler class used to handle token calls (on /new route)<br>
 * Required POST method<br>
 * <br>
 * Creates a new unique session id [10000-99999] and returns it<br>
 * Returns 503 server busy if there are no available sessions<br>
 * Returns 422 otherwise<br>
 */
public class TokenHandler implements HttpHandler {

    /**
     * Method that handles /new route
     * @param exchange - inherited HttpExchange object
     * @throws IOException
     */
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        if(requestMethod.equalsIgnoreCase("POST")) {
            Random random = new Random();
            int sessionId = 0;
            if(APIServer.ids.size() == 89999) {
                String response = "There are no available sessions, try again later";
                exchange.sendResponseHeaders(503, response.length());
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            while(sessionId<10000 && !APIServer.ids.contains(sessionId)) {
                sessionId = random.nextInt(89999) + 10000;
            }
            APIServer.ids.add(sessionId);

            String response = "Your session id is -> "+ sessionId;
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();

        }
        else {
            String response = "Use POST method for better results";
            exchange.sendResponseHeaders(422, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        }
    }
}
