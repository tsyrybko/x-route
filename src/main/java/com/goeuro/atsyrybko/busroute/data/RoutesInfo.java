package com.goeuro.atsyrybko.busroute.data;

import gnu.trove.set.hash.TIntHashSet;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains data about all routes
 */
public class RoutesInfo {

    private static final RoutesInfo SINGLETON = new RoutesInfo();

    public static RoutesInfo getInstance() {
        return SINGLETON;
    }

    private final List<TIntHashSet> sourceList;

    public void addRouteInfo(TIntHashSet routeInfo) {
        sourceList.add(routeInfo);
    }

    public List<TIntHashSet> getRoutes() {
        return sourceList;
    }

    private RoutesInfo() {
        sourceList = new LinkedList<>();
    }
}
