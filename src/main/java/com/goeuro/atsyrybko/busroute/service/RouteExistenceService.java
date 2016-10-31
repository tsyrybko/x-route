package com.goeuro.atsyrybko.busroute.service;

import com.goeuro.atsyrybko.busroute.data.RoutesInfo;
import gnu.trove.set.hash.TIntHashSet;

import java.util.List;

/**
 * Finds information if departure is directly connected with arrival station
 */
public class RouteExistenceService {

    private List<TIntHashSet> routes = RoutesInfo.getInstance().getRoutes();

    public Boolean isDirectlyConnected(int depSid, int arrSid) {
        TIntHashSet input = new TIntHashSet(2);
        input.add(depSid);
        input.add(arrSid);
        for(TIntHashSet set : routes) {
            if (set.containsAll(input)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
