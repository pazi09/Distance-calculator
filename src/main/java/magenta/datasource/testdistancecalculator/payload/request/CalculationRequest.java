package magenta.datasource.testdistancecalculator.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CalculationRequest {

    @NotBlank
    @Size(min=2,max=20)
    private String calculationType;

    @NotBlank
    @Size(min=2,max=20)
    private String fromCity;

    @NotBlank
    @Size(min=2,max=20)
    private String toCity;
}
