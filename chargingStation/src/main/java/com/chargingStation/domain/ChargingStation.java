package com.chargingStation.domain;


import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chargingStation")
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String zipCode;

    private Point geoLocation;

    public ChargingStation() {
    }

    public ChargingStation(Long id, String zipCode, Point geoLocation) {
        this.id = id;
        this.zipCode = zipCode;
        this.geoLocation = geoLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Point getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Point geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargingStation that = (ChargingStation) o;
        return Objects.equals(id, that.id) && Objects.equals(zipCode, that.zipCode) && Objects.equals(geoLocation, that.geoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zipCode, geoLocation);
    }
}
