package magenta.datasource.testdistancecalculator.payload.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AllCalculationResponse {

    @NotBlank
    @Size(min=2,max=20)
    private String calculationType;

    @NotBlank
    private double distance1;

    @NotBlank
    private double distance2;

    public AllCalculationResponse(String calculationType, double distance1, double distance2){
        this.calculationType = calculationType;
        this.distance1 = distance1;
        this.distance2 = distance2;
    }
}
