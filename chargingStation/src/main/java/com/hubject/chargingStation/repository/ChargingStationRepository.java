package com.hubject.chargingStation.repository;

import com.hubject.chargingStation.domain.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, String>, JpaSpecificationExecutor<ChargingStation> {
    ChargingStation findById(long Id);

}
