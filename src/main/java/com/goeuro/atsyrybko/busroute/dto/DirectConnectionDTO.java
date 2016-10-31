package com.goeuro.atsyrybko.busroute.dto;

/**
 * Created by arseni on 30.10.16.
 */
public class DirectConnectionDTO {
    private Integer dep_sid;
    private Integer arr_sid;
    private Boolean direct_bus_route;

    public DirectConnectionDTO(Integer dep_sid, Integer arr_sid, Boolean direct_bus_route) {
        this.dep_sid = dep_sid;
        this.arr_sid = arr_sid;
        this.direct_bus_route = direct_bus_route;
    }

    public Integer getDep_sid() {
        return dep_sid;
    }

    public void setDep_sid(Integer dep_sid) {
        this.dep_sid = dep_sid;
    }

    public Integer getArr_sid() {
        return arr_sid;
    }

    public void setArr_sid(Integer arr_sid) {
        this.arr_sid = arr_sid;
    }

    public Boolean getDirect_bus_route() {
        return direct_bus_route;
    }

    public void setDirect_bus_route(Boolean direct_bus_route) {
        this.direct_bus_route = direct_bus_route;
    }
}
