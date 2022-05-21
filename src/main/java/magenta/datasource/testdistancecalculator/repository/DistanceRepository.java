package magenta.datasource.testdistancecalculator.repository;

import magenta.datasource.testdistancecalculator.entities.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends JpaRepository<Distance,Long> {
}
