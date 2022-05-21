package magenta.datasource.testdistancecalculator.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Distance")
public class Distance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String from_city;

    @Column
    private String to_city;

}
