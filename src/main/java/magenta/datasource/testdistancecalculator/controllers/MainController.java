package magenta.datasource.testdistancecalculator.controllers;

import magenta.datasource.testdistancecalculator.entities.City;
import magenta.datasource.testdistancecalculator.payload.request.CalculationRequest;
import magenta.datasource.testdistancecalculator.payload.response.CalculationResponse;
import magenta.datasource.testdistancecalculator.serviceInterface.CalculationServiceInterface;
import magenta.datasource.testdistancecalculator.serviceInterface.ListServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final ListServiceInterface listService;
    private final CalculationServiceInterface calculationService;

    @Autowired
    public MainController(ListServiceInterface listService, CalculationServiceInterface calculationService){
        this.listService = listService;
        this.calculationService = calculationService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> showCityList(){
        return listService.showAll();
    }

    @GetMapping("/distance-calc")
    public ResponseEntity<?> distanceCalc(@Valid @RequestBody CalculationRequest calculationRequest){
        if(calculationRequest.getCalculationType() == "Crowflight") {
            return ResponseEntity.ok(new CalculationResponse(calculationRequest.getCalculationType(),
                  calculationService.crowFlight(calculationRequest.getFromCity(), calculationRequest.getToCity())
           ));
        }
        else if(calculationRequest.getCalculationType() == "Distance matrix"){
            return ResponseEntity.ok(new CalculationResponse(calculationRequest.getCalculationType(),
                    calculationService.distanceMatrix(calculationRequest.getFromCity(), calculationRequest.getToCity())
            ));
        }
        return null;
    }
}
