package com.romanccoder.challenge.bus.model;

public class RouteData {

    private int id;
    private int[] stationIds;

    public RouteData(int id, int[] stationIds) {
        this.id = id;
        this.stationIds = stationIds;
    }

    public int getStationId() {
        return id;
    }

    public int[] getArrivalIds() {
        return stationIds;
    }
}
