package com.goeuro.atsyrybko.busroute;

import gnu.trove.set.hash.TIntHashSet;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arseni on 30.10.16.
 */
public class App {
    public static final String BASE_URI = "http://localhost:8099/api/";
    public static final List<TIntHashSet> SOURCE_LIST = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        readFile(args);

        final HttpServer server = startServer();
        System.out.println("App started. Hit enter to stop it...");
        System.in.read();
        server.shutdownNow();
    }

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.goeuro.atsyrybko.busroute.rest");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void readFile(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(/*args[0]*/"./txt/route_data_large.txt"));
        Integer qq = Integer.parseInt(br.readLine().split(" ")[0]);

        for (int i=0; i< qq;i++) {
            System.out.println("Route : " + i);


            SOURCE_LIST.add(getRoute(br.readLine()));

            }


        br.close();



        System.out.print("********** PARSED ************");
    }

    private static TIntHashSet getRoute(String line) {
        String[] routeArray = line.split(" ");

        TIntHashSet result = new TIntHashSet(routeArray.length);
        for (int i=1; i<routeArray.length; i++) {
            int element = Integer.parseInt(routeArray[i]);
            result.add(element);
        }

        return result;
    }
}