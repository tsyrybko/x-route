package com.goeuro.atsyrybko.busroute;

import com.goeuro.atsyrybko.busroute.service.RoutesParsingService;
import com.goeuro.atsyrybko.busroute.service.ServerInitialisationService;

import java.io.IOException;

/**
 * Main application class
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        RoutesParsingService routesParsingService = new RoutesParsingService();
        routesParsingService.readFile(args[0]);

        new ServerInitialisationService().startServer();
        Thread.currentThread().join();
    }

}