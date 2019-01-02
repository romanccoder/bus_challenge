package com.romanccoder.challenge.bus.repository;

// Array storage could be changed to Redis storage, as it gives more
public class RedisRouteDataRepository implements RouteDataRepository {

    @Override
    public boolean hasDirectRoute(int departureId, int arrivalId) {
        // Some Redis implementation
        return false;
    }
}
