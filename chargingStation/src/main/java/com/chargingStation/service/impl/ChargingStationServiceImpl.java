package com.chargingStation.service.impl;

import com.chargingStation.domain.ChargingStation;
import com.chargingStation.repository.ChargingStationRepository;
import com.chargingStation.service.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingStationServiceImpl  implements ChargingStationService {
    @Autowired
    ChargingStationRepository chargingStationRepository;

    @Override
    public List<ChargingStation> findByZipCode(String zipCode) {
        return chargingStationRepository.findByZipCode(zipCode);
    }

    @Override
    public List<ChargingStation> findByGeoLocation(Point geoLocation) {
        return chargingStationRepository.findByGeoLocation(geoLocation);
    }

    @Override
    public ChargingStation findById(long id) {
        return chargingStationRepository.findById(id);
    }

    @Override
    public void save(ChargingStation chargingStation) {
    chargingStationRepository.save(chargingStation);
    }

    @Override
    public Iterable<ChargingStation> findAll() {
        return chargingStationRepository.findAll();
    }
}
