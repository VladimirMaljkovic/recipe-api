package rs.ac.bg.fon.is.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import rs.ac.bg.fon.is.server.APIServer;
import rs.ac.bg.fon.is.server.handlers.session.AllRecipesHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

public class BaseHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestMethod = exchange.getRequestMethod();

        String path = exchange.getRequestURI().getPath();
        long dashNumber = path.chars().filter(ch -> ch == '/').count();
        if(Objects.equals(path, "/")) {
            APIServer.getInstance().getHandlers().get("root").getHandler().handle(exchange);
        }
        else if (Objects.equals(path, "/new")) {
            APIServer.getInstance().getHandlers().get("token").getHandler().handle(exchange);
        }
        // /12345/recipes (2 dashes)
        else if (dashNumber == 2) {
            int id;
            String[] parts = path.split("/", 3);
            String idString = parts[1];
            String myPath = parts[2];

            if(canConvertToInt(idString)) {
                id = Integer.parseInt(idString);
                if (id > 9999 && id < 100000) {
                    if(myPath.equalsIgnoreCase("recipes")) {
                        if(APIServer.ids.contains(id)) {
                            APIServer.getInstance().getHandlers().put(idString + myPath, new PathHandlerPair(idString + myPath, new AllRecipesHandler(id)));
                            APIServer.getInstance().getHandlers().get(idString+myPath).getHandler().handle(exchange);
                        }
                        else {
                            APIServer.getInstance().getHandlers().get("invalid").getHandler().handle(exchange);
                        }
                    }
                }
                else
                {
                    APIServer.getInstance().getHandlers().get("invalid").getHandler().handle(exchange);
                }
            }
        }
        else {
            APIServer.getInstance().getHandlers().get("invalid").getHandler().handle(exchange);

        }

    }

    public boolean canConvertToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}