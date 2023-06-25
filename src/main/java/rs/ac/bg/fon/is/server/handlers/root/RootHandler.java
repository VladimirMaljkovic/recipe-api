package rs.ac.bg.fon.is.server.handlers.root;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Handler class used to handle root calls (on / route)<br>
 * Required GET method<br>
 * <br>
 * Displays a guide for using the api service<br>
 * Returns 422 otherwise<br>
 */
public class RootHandler implements HttpHandler {

    private static final String HTML_FILE_PATH = "src/main/resources/html/recipe_api.html";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        File htmlFile = new File(HTML_FILE_PATH);
        String requestMethod = exchange.getRequestMethod();

        if(requestMethod.equalsIgnoreCase("GET")) {
            if (htmlFile.exists()) {
                byte[] htmlContent = Files.readAllBytes(htmlFile.toPath());

                // Set the response headers
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, htmlContent.length);

                // Send the response body
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(htmlContent);
                outputStream.close();
                exchange.close(); //?
            } else {
                // If the file doesn't exist, return a 404 error
                System.out.println("File doesn't exist");
                exchange.sendResponseHeaders(404, -1);
                exchange.close(); //?
            }
        }
        else {
            String response = "Use GET method for better results";
            exchange.sendResponseHeaders(422, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            exchange.close(); //?
        }
    }
}