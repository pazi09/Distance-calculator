package magenta.datasource.testdistancecalculator.serviceInterface;

import magenta.datasource.testdistancecalculator.entities.City;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListServiceInterface {

    ResponseEntity<List<City>> showAll();
}
