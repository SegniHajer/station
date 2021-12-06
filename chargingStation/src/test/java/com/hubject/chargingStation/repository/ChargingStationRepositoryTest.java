package com.hubject.chargingStation.repository;

import com.hubject.chargingStation.domain.ChargingStation;
import com.hubject.chargingStation.repository.ChargingStationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ChargingStationRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String ZIP_CODE = "10245 Berlin";
    private static final String IMAGE_URL = "http://an-imageurl.com/image1.jpg";

    @Autowired
    private ChargingStationRepository chargingStationRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
        ChargingStation chargingStation=new ChargingStation();
        Point geoLocation=new Point(49.788391,13.989580);
        chargingStation.setZipCode(ZIP_CODE);
        chargingStation.setGeoLocation(geoLocation);
        //when
        chargingStationRepository.save(chargingStation);

        //then
        Assert.assertNotNull(chargingStation.getId());
        ChargingStation newStation = chargingStationRepository.findById(chargingStation.getId());
        Assert.assertEquals((Long) 1L, newStation.getId());
        Assert.assertEquals(ZIP_CODE, newStation.getZipCode());
    }
}