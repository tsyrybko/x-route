package com.goeuro.atsyrybko.busroute;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by arseni on 30.10.16.
 */
public class App {
    public static final String BASE_URI = "http://localhost:8089/api/";
    public static final Map<Integer, Set<Integer>> SOURCE_MAP = new TreeMap<>();
    public static final Set<Integer> SOURCE_SET = new HashSet<>();
    public static final List<Set<Integer>> SOURCE_LIST = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //LargeFileGenerator.generate("./txt/route_data_large.txt");

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
        BufferedReader br = new BufferedReader(new FileReader/*("./txt/test.txt"));*/(/*args[0]*/"./txt/route_data_large.txt"));
        Integer qq = Integer.parseInt(br.readLine().split(" ")[0]);

        for (int i=0; i< qq;i++) {
            System.out.println("Route : " + i);

            SOURCE_LIST.add(getRoute(br.readLine()));

        }

        br.close();



        System.out.print("********** PARSED ************");
    }

    private static Set<Integer> getRoute(String line) {
        String[] routeArray = line.split(" ");

        Set result = new HashSet(routeArray.length);
        for (int i=1; i<routeArray.length; i++) {
            Integer element = Integer.parseInt(routeArray[i]);
            result.add(element);
        }

        return result;
    }
}