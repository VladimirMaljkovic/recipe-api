package rs.ac.bg.fon.is.server.handlers;

import com.sun.net.httpserver.HttpHandler;

public abstract class IdHttpHandler implements HttpHandler {
    private int id;

    public IdHttpHandler(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
