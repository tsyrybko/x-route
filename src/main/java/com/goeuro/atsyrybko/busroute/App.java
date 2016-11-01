package com.goeuro.atsyrybko.busroute;

import com.goeuro.atsyrybko.busroute.service.RoutesParsingService;
import com.goeuro.atsyrybko.busroute.service.ServerInitialisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Main application class
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoutesParsingService.class);

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args == null || args.length == 0 || args[0].isEmpty()) {
            LOGGER.error("Please define file name as a parameter in command line and try again.");
            return;
        }

        RoutesParsingService routesParsingService = new RoutesParsingService();
        routesParsingService.readFile(args[0]);

        new ServerInitialisationService().startServer();
        Thread.currentThread().join();
    }

}