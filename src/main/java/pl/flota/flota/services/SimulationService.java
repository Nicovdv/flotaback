package pl.flota.flota.services;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.flota.flota.repositories.CarsDAO;
import pl.flota.flota.repositories.CarsDTO;

@Service
@Slf4j
public class SimulationService {

  private static final Integer speed = 1000;

  @Autowired
  private GeoApiContext geoApiContext;

  @Autowired
  private CarsDAO carsDAO;

  public void startSimulation(String origin, String destination, String reg) {
    new Thread(() -> {
      DirectionsResult result = null;
      try {
        result = DirectionsApi.newRequest(geoApiContext).origin(origin).destination(destination).await();
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (result.routes.length > 0) {
        CarsDTO car = carsDAO.findByReg(reg);
        car.setLati(result.routes[0].overviewPolyline.decodePath().get(0).lat);
        car.setLongi(result.routes[0].overviewPolyline.decodePath().get(0).lng);
        car.setActive(true);
        car = carsDAO.save(car);

        for (com.google.maps.model.LatLng latLng : result.routes[0].overviewPolyline.decodePath()) {
          car.setLati(latLng.lat);
          car.setLongi(latLng.lng);
          carsDAO.save(car);
          try {
            Thread.sleep(speed); //opoznienie
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        car.setActive(false);
        carsDAO.save(car);
      }
    }).start();
  }
}
