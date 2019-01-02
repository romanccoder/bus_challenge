package com.romanccoder.challenge.bus.service;

import com.romanccoder.challenge.bus.dto.DirectRouteResultDto;

public interface RouteDataService {
    DirectRouteResultDto hasDirect(int departureId, int arrivalId);
}
