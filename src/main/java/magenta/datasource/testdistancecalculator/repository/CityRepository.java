package magenta.datasource.testdistancecalculator.repository;

import magenta.datasource.testdistancecalculator.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}