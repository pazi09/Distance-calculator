package magenta.datasource.testdistancecalculator.repository;

import magenta.datasource.testdistancecalculator.entities.DistanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends JpaRepository<DistanceInfo,Long> {
    DistanceInfo findByFromCityAndToCity(String fromCity, String toCity);
}
