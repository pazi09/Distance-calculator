package magenta.datasource.testdistancecalculator.controllers;

import magenta.datasource.testdistancecalculator.entities.City;
import magenta.datasource.testdistancecalculator.payload.request.CalculationRequest;
import magenta.datasource.testdistancecalculator.payload.response.AllCalculationResponse;
import magenta.datasource.testdistancecalculator.payload.response.CalculationResponse;
import magenta.datasource.testdistancecalculator.serviceInterface.CalculationServiceInterface;
import magenta.datasource.testdistancecalculator.serviceInterface.ListServiceInterface;
import magenta.datasource.testdistancecalculator.serviceInterface.UploadServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final ListServiceInterface listService;
    private final CalculationServiceInterface calculationService;
    private final UploadServiceInterface uploadService;


    @Autowired
    public MainController(ListServiceInterface listService, CalculationServiceInterface calculationService,
                          UploadServiceInterface uploadService){
        this.listService = listService;
        this.calculationService = calculationService;
        this.uploadService = uploadService;
    }

    @GetMapping("/cities")
    public ResponseEntity<?> showCityList(){

        return listService.showAll();
    }

    @GetMapping("/distance-calc")
    public ResponseEntity<?> distanceCalc(@Valid @RequestBody CalculationRequest calculationRequest){
        if(calculationRequest.getCalculationType().equals("Crowflight")) {
            return ResponseEntity.ok(new CalculationResponse(calculationRequest.getCalculationType(),
                  calculationService.crowFlight(calculationRequest.getFromCity(), calculationRequest.getToCity())
           ));
        }
        else if(calculationRequest.getCalculationType().equals("Distance matrix")){
            return ResponseEntity.ok(new CalculationResponse(calculationRequest.getCalculationType(),
                    calculationService.distanceMatrix(calculationRequest.getFromCity(), calculationRequest.getToCity())
            ));
        }
        else if(calculationRequest.getCalculationType().equals("All")){
            return ResponseEntity.ok(new AllCalculationResponse(calculationRequest.getCalculationType(),
                    calculationService.crowFlight(calculationRequest.getFromCity(), calculationRequest.getToCity()),
                    calculationService.distanceMatrix(calculationRequest.getFromCity(), calculationRequest.getToCity())));
        }
        return null;
    }

    @PostMapping("/upload")
    public HttpStatus uploadData(@RequestParam("file") MultipartFile multipartFile)  {
        try {
            uploadService.uploadData(multipartFile);
            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
