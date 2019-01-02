package com.romanccoder.challenge.bus.repository;

public interface RouteDataRepository {
    boolean hasDirectRoute(int departureId, int arrivalId);
}
