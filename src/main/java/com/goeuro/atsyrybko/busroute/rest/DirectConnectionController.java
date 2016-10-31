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
        /*Integer res;
        if (dep_sid<arr_sid) {
            res = (((Double)(0.5 * (dep_sid + arr_sid) * (dep_sid + arr_sid + 1) + arr_sid)).intValue());
        } else {
            res = (((Double)(0.5 * (arr_sid + dep_sid) * (arr_sid + dep_sid+ 1) + dep_sid)).intValue());
        }
        return new DirectConnectionDTO(dep_sid, arr_sid, App.SOURCE_SET.contains(res));*/

        /*Set<Integer> s1 =App.SOURCE_MAP.get(dep_sid);
        Set<Integer> s2 =App.SOURCE_MAP.get(arr_sid);
        return new DirectConnectionDTO(dep_sid, arr_sid, s1!=null && s2!=null && !Collections.disjoint(s1, s2));*/
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


