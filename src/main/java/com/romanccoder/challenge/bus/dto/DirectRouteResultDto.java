package com.romanccoder.challenge.bus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectRouteResultDto {

    @JsonProperty("dep_sid")
    private int departureId;
    @JsonProperty("arr_sid")
    private int arrivalId;
    @JsonProperty("direct_bus_route")
    private boolean hasDirectRoute;

    public DirectRouteResultDto(int departureId, int arrivalId, boolean hasDirectRoute) {
        this.departureId = departureId;
        this.arrivalId = arrivalId;
        this.hasDirectRoute = hasDirectRoute;
    }

    public int getDepartureId() {
        return departureId;
    }

    public int getArrivalId() {
        return arrivalId;
    }

    public boolean hasDirectRoute() {
        return hasDirectRoute;
    }
}
