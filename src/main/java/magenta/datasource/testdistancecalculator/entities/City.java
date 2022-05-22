package magenta.datasource.testdistancecalculator.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private double latitude;

    @Column
    private double longitude;


}
