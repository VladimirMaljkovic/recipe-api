package rs.ac.bg.fon.is.server.handlers;

import com.sun.net.httpserver.HttpHandler;

/**
 * Class used to represent paths and their respective handlers
 */
public class PathHandlerPair {
    /**
     * Path string
     */
    private String path;
    /**
     * Handler object tied to that path
     */
    private HttpHandler handler;

    /**
     * Constructs a path-handler pair
     * @param path - path string
     * @param handler - handler object
     */
    public PathHandlerPair(String path, HttpHandler handler) {
        this.path = path;
        this.handler = handler;
    }

    public String getPath() {
        return path;
    }

    public HttpHandler getHandler() {
        return handler;
    }
}
