package com.chargingStation.service;

import com.chargingStation.domain.ChargingStation;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChargingStationService {
    List<ChargingStation> findByZipCode(String zipCode);

    List<ChargingStation> findByGeoLocation(Point geoLocation);

    ChargingStation findById(long id);

    void save(ChargingStation chargingStation);

    Iterable<ChargingStation> findAll();
}
