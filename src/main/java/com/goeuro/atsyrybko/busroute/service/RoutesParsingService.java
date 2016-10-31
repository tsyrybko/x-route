package com.goeuro.atsyrybko.busroute.service;

import com.goeuro.atsyrybko.busroute.data.RoutesInfo;
import gnu.trove.set.hash.TIntHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads data from routes
 */
public class RoutesParsingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoutesParsingService.class);

    public void readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Integer qq = Integer.parseInt(br.readLine().split(" ")[0]);

        RoutesInfo routesInfo = RoutesInfo.getInstance();
        for (int i=0; i< qq;i++) {
            String line = br.readLine();
            TIntHashSet routeInfo = getRoute(line);
            routesInfo.addRouteInfo(routeInfo);
        }
        br.close();
        LOGGER.info("Routes are parsed.");
    }

    private TIntHashSet getRoute(String line) {
        String[] routeArray = line.split(" ");

        TIntHashSet result = new TIntHashSet(routeArray.length);
        for (int i=1; i<routeArray.length; i++) {
            int element = Integer.parseInt(routeArray[i]);
            result.add(element);
        }

        return result;
    }
}
