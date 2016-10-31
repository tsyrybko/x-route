package com.goeuro.atsyrybko.busroute;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
        Integer qq = Integer.valueOf(br.readLine().split(" ")[0]);
        //String[] arrx = new String[qq];
        for (int i=0; i< qq;i++) {
            System.out.println("Route : " + i);
            /*arrx[i] =*/ Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //arr = br.readLine().split(" ");

            TreeSet<Integer> set = new TreeSet<>(Arrays.<Integer>asList(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()));
            /*for (int j = 1; j < arr.length; j++) {
                set.add(Integer.valueOf(arr[j]));
            }*/

            SOURCE_LIST.add(set);

            /*int route  = Integer.valueOf(arr[0]);
            for (int j = 1; j < arr.length; j++) {
                Integer station = Integer.valueOf(arr[j]);
                Set<Integer> set = SOURCE_MAP.get(station);
                if (set == null) {
                    set = new TreeSet<Integer>();
                    set.add(route);
                    SOURCE_MAP.put(station, set);


                } else {
                    set.add(route);
                }
            }*/

            /*for (int j = 1; j < arr.length; j++) {
                int i1=Integer.valueOf(arr[j]);
                for (int k = j +1; k < arr.length; k++) {
                    int i2=Integer.valueOf(arr[k]);
                    if (i1<i2) {
                        SOURCE_SET.add(((Double)(0.5 * (i1 + i2) * (i1 + i2 + 1) + i2)).intValue());
                    } else {
                        SOURCE_SET.add(((Double)(0.5 * (i2 + i1) * (i2 + i1+ 1) + i1)).intValue());
                    }
                }
            }*/

        }

        br.close();



        System.out.print("**********************");



    }
}