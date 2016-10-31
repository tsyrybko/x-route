package com.goeuro.atsyrybko.busroute.service;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Create http server instance
 */
public class ServerInitialisationService {
    private static final String BASE_URI = "http://localhost:8088/api/";
    private static final String PACKAGE = "com.goeuro.atsyrybko.busroute.rest";

    public HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages(PACKAGE);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
}
