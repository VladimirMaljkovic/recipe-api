package rs.ac.bg.fon.is.server;

import com.sun.net.httpserver.HttpServer;
import rs.ac.bg.fon.is.server.handlers.PathHandlerPair;
import rs.ac.bg.fon.is.server.handlers.root.RootHandler;
import rs.ac.bg.fon.is.server.handlers.root.TestHandler;
import rs.ac.bg.fon.is.server.handlers.root.TokenHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

/**
 * This class represents and API server that runs on PORT
 * It has a list of handlers that handle their respective url paths
 */
public class APIServer {

    /**
     * PORT the webserver will run on
     */
    private final int PORT = 8080;

    /**
     * List of PathHandlerPair objects that contain...paths and their respective handlers
     */
    private ArrayList<PathHandlerPair> handlers;

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
        handlers = new ArrayList<>();
        handlers.add(new PathHandlerPair("/test", new TestHandler()));
        handlers.add(new PathHandlerPair("/", new RootHandler()));
        // handlers.add(new PathHandlerPair("/", new GetAllRecipesHandler()));
        handlers.add(new PathHandlerPair("/new", new TokenHandler()));
    }

    /**
     * Runs the APIServer on specified port - loads all registered paths and their respective handlers
     * @throws IOException
     */
    public void runServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        for (PathHandlerPair pair: handlers) {
            server.createContext(pair.getPath(), pair.getHandler());
        }

        server.start();

        System.out.println("Server running on 127.0.0.1:" + PORT);
    }

}
