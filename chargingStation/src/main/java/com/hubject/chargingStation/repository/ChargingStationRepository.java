package com.hubject.chargingStation.repository;

import com.hubject.chargingStation.domain.ChargingStation;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, String>, JpaSpecificationExecutor<ChargingStation> {
    ChargingStation findById(long Id);
    List<ChargingStation> findByZipCode(String zipCode);
    List<ChargingStation> findByGeoLocation(Point point);

 //   String HAVERSINE_FORMULA = "(6371 * acos(cos(radians(:x)) * cos(radians(s.geo_location.x)) *" +
  //          " cos(radians(s.geo_location.y) - radians(:y)) + sin(radians(:x)) * sin(radians(s.x))))";
 //   @Query("SELECT s FROM charging_station s WHERE " + HAVERSINE_FORMULA + " < :perimeter ORDER BY "+ HAVERSINE_FORMULA + " DESC")
  //  List<ChargingStation> findByArea(@Param("x") double x, @Param("y") double y, @Param("perimeter") double  perimeter);
}
