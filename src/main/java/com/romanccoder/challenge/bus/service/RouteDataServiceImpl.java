package com.romanccoder.challenge.bus.service;

import com.romanccoder.challenge.bus.dto.DirectRouteResultDto;
import com.romanccoder.challenge.bus.repository.RouteDataRepository;
import com.romanccoder.challenge.bus.service.RouteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteDataServiceImpl implements RouteDataService {

    @Autowired
    private RouteDataRepository routeDataRepository;

    @Override
    public DirectRouteResultDto hasDirect(int departureId, int arrivalId) {
        return new DirectRouteResultDto(departureId, arrivalId, routeDataRepository.hasDirectRoute(departureId, arrivalId));
    }
}
