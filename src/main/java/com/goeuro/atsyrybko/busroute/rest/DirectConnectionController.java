package com.goeuro.atsyrybko.busroute.rest;

import com.goeuro.atsyrybko.busroute.App;
import com.goeuro.atsyrybko.busroute.dto.DirectConnectionDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by arseni on 30.10.16.
 */
@Path("direct")
public class DirectConnectionController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DirectConnectionDTO getIt(@QueryParam("dep_sid") int dep_sid, @QueryParam("arr_sid") int arr_sid) {

        Set<Integer> input = new TreeSet<>();
        input.add(dep_sid);
        input.add(arr_sid);
        for(Set<Integer> set : App.SOURCE_LIST) {
            if (set.containsAll(input)) {
                return new DirectConnectionDTO(dep_sid, arr_sid, Boolean.TRUE);
            }
        }
        return new DirectConnectionDTO(dep_sid, arr_sid, Boolean.FALSE);
    }
}

