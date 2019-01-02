package com.romanccoder.challenge.bus.controller;

import com.romanccoder.challenge.bus.dto.DirectRouteResultDto;
import com.romanccoder.challenge.bus.service.RouteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouteDataController {

    @Autowired
    private RouteDataService routeDataService;

    @GetMapping("/direct")
    public DirectRouteResultDto hasDirect(@RequestParam("dep_sid") int departureId, @RequestParam("arr_sid") int arrivalId) {
        return routeDataService.hasDirect(departureId, arrivalId);
    }
}
