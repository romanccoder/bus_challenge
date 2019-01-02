package com.romanccoder.challenge.bus.loader;

import com.romanccoder.challenge.bus.model.RouteData;

import java.util.List;

public interface RouteDataLoader {
    List<RouteData> load();
}
