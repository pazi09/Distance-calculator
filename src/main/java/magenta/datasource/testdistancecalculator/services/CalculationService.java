package magenta.datasource.testdistancecalculator.services;

import magenta.datasource.testdistancecalculator.repository.CityRepository;
import magenta.datasource.testdistancecalculator.repository.DistanceRepository;
import magenta.datasource.testdistancecalculator.serviceInterface.CalculationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService implements CalculationServiceInterface {

    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;

    @Autowired
    public  CalculationService(CityRepository cityRepository, DistanceRepository distanceRepository){
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    public double crowFlight(String city1, String city2){
        double lon1= cityRepository.findByName(city1).getLongitude();
        double lon2= cityRepository.findByName(city2).getLongitude();
        double lat1= cityRepository.findByName(city1).getLatitude();
        double lat2= cityRepository.findByName(city2).getLatitude();


        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));


        double r = 6371;

        return(c * r);

    }

    public double distanceMatrix(String city1, String city2){
        if (distanceRepository.findByFromCityAndToCity(city1,city2).getDistance() != 0) {
            return distanceRepository.findByFromCityAndToCity(city1, city2).getDistance();
        }
        return 0;
    }

}
