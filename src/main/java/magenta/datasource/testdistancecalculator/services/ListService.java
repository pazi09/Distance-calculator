package magenta.datasource.testdistancecalculator.services;

import magenta.datasource.testdistancecalculator.entities.City;
import magenta.datasource.testdistancecalculator.repository.CityRepository;
import magenta.datasource.testdistancecalculator.serviceInterface.ListServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ListService implements ListServiceInterface {

    private final CityRepository cityRepository;

    @Autowired
    public ListService(CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }

    @Override
    public ResponseEntity<?>  showAll(){
        try {
            List<City> cities = new ArrayList<City>();
            cityRepository.findAll().forEach(cities::add);
            if (cities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
