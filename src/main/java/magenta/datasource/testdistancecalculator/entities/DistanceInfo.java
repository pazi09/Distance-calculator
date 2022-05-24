package magenta.datasource.testdistancecalculator.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DistanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String fromCity;

    @Column
    private String toCity;

    @Column
    private double distance;

}
