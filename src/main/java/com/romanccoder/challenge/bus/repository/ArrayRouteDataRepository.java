package com.romanccoder.challenge.bus.repository;

import com.romanccoder.challenge.bus.model.RouteData;
import com.romanccoder.challenge.bus.loader.RouteDataLoader;
import org.agrona.collections.Int2ObjectHashMap;
import org.agrona.collections.IntHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ArrayRouteDataRepository implements RouteDataRepository {

    @Autowired
    private RouteDataLoader routeDataLoader;

    // I use Int2ObjectHashMap and IntHashSet which are simple HashMap/HashSet but uses int primitive instead of Integer wrapper (to reduce memory usage)
    private Int2ObjectHashMap<IntHashSet> stationData;

    public ArrayRouteDataRepository() {
        stationData = new Int2ObjectHashMap<>();
    }

    @PostConstruct
    private void initialize() {
        List<RouteData> routeDataList = routeDataLoader.load();

        for (RouteData data : routeDataList) {

            for (int i = 0; i < data.getArrivalIds().length; i++) {
                if (i == data.getArrivalIds().length - 1) {
                    continue;
                }

                int departureStationId = data.getArrivalIds()[i];

                stationData.putIfAbsent(departureStationId, new IntHashSet(-1));

                for (int j = i + 1; j < data.getArrivalIds().length; j++) {
                    int arrivalStationId = data.getArrivalIds()[j];
                    stationData.get(departureStationId).add(arrivalStationId);
                }
            }
        }
    }

    @Override
    public boolean hasDirectRoute(int departureId, int arrivalId) {
        IntHashSet arrivalIds = stationData.get(departureId);
        IntHashSet arrivalIdsReversed = stationData.get(arrivalId);

        // If such departure doesn't exist at all
        if (arrivalIds == null) {
            return false;
        }

        return arrivalIds.contains(arrivalId) || (arrivalIdsReversed != null && arrivalIdsReversed.contains(departureId));
    }
}
