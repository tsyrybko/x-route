package com.goeuro.atsyrybko.busroute.rest;

import com.goeuro.atsyrybko.busroute.dto.DirectConnectionDTO;
import com.goeuro.atsyrybko.busroute.service.RouteExistenceService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Handle request about direct connection between two stations
 */
@Path("direct")
public class DirectConnectionController {

    private final RouteExistenceService routeExistenceService = new RouteExistenceService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DirectConnectionDTO getIt(@QueryParam("dep_sid") int dep_sid, @QueryParam("arr_sid") int arr_sid) {
        Boolean directlyConnected = routeExistenceService.isDirectlyConnected(dep_sid, arr_sid);
        return new DirectConnectionDTO(dep_sid, arr_sid, directlyConnected);
    }
}


