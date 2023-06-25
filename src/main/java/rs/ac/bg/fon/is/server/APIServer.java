package rs.ac.bg.fon.is.server;

import com.sun.net.httpserver.HttpServer;
import rs.ac.bg.fon.is.server.handlers.InvalidRouteHandler;
import rs.ac.bg.fon.is.server.handlers.PathHandlerPair;
import rs.ac.bg.fon.is.server.handlers.root.RootHandler;
import rs.ac.bg.fon.is.server.handlers.root.TestHandler;
import rs.ac.bg.fon.is.server.handlers.root.TokenHandler;
import rs.ac.bg.fon.is.server.handlers.BaseHandler;
import rs.ac.bg.fon.is.server.handlers.session.AllRecipesHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents and API server that runs on PORT
 * It has a list of handlers that handle their respective url paths
 */
public class APIServer {

    //TODO document this shit
    private static APIServer instance;

    public static APIServer getInstance() {
        if (instance == null) {
            synchronized (APIServer.class) {
                if (instance == null) {
                    instance = new APIServer();
                }
            }
        }
        return instance;
    }

    /**
     * PORT the webserver will run on
     */
    private final int PORT = 8080;

    /**
     * List of PathHandlerPair objects that contain...paths and their respective handlers
     */
    private final Map<String, PathHandlerPair> handlers = new HashMap<>();

    /**
     * List of registered session ids
     */
    public static ArrayList<Integer> ids;

    /**
     * Constructs a new APIServer object, initializes sessionId and handlers lists
     * This is where new path-handler pairs are added
     */
    public APIServer() {
        ids = new ArrayList<>();
        handlers.put("test", new PathHandlerPair("/test", new TestHandler()));
        handlers.put("base", new PathHandlerPair("/", new BaseHandler()));
        handlers.put("root", new PathHandlerPair("/", new RootHandler()));
        handlers.put("token", new PathHandlerPair("/new", new TokenHandler()));
        handlers.put("invalid", new PathHandlerPair("/", new InvalidRouteHandler()));
    }

    /**
     * Runs the APIServer on specified port - loads all registered paths and their respective handlers
     * @throws IOException
     */
    public void runServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);


        server.createContext(handlers.get("base").getPath(), handlers.get("base").getHandler());

        server.start();

        System.out.println("Server running on 127.0.0.1:" + PORT);
    }

    public Map<String, PathHandlerPair> getHandlers() {
        return handlers;
    }
}
