package magenta.datasource.testdistancecalculator.payload.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CalculationResponse {

    @NotBlank
    @Size(min=2,max=20)
    private String calculationType;

    @NotBlank
    private double distance;

    public CalculationResponse(String calculationType, double distance){
        this.calculationType=calculationType;
        this.distance=distance;
    }
}
