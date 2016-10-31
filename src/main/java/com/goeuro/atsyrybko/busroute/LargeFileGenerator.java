package com.goeuro.atsyrybko.busroute;

        //import org.slf4j.Logger;
        //import org.slf4j.LoggerFactory;

        import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO Documentation
 */
public class LargeFileGenerator {

    //private static final Logger LOGGER = LoggerFactory.getLogger(LargeFileGenerator.class);

    private static final int ROUTES_LIMIT =            100000;
    private static final int STATIONS_LIMIT =          1000000;
    private static final int STATIONS_IN_ROUTE_LIMIT = 1000;

    private static Random randomGenerator = new Random();

    public static void generate(String fileName) {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(ROUTES_LIMIT);
            for (int i=0; i<ROUTES_LIMIT; i++) {
                //LOGGER.debug("generate string {}", i);
                String route = createRouteLine(i);
                writer.println(route);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String createRouteLine(Integer routeId) {
        Set<Integer> stations = new HashSet<Integer>(STATIONS_IN_ROUTE_LIMIT);
        while (stations.size() < STATIONS_IN_ROUTE_LIMIT) {
            Integer sid = randomGenerator.nextInt(STATIONS_LIMIT);
            stations.add(sid);
        }

        LinkedList<String> stationsList = stations.stream()
                .map(i -> i.toString())
                .collect(Collectors.toCollection(LinkedList::new));
        stationsList.offerFirst(routeId.toString());

        return String.join(" ", stationsList);
    }
}