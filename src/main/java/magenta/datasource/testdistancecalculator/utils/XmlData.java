package magenta.datasource.testdistancecalculator.utils;


import lombok.Data;
import magenta.datasource.testdistancecalculator.entities.City;
import magenta.datasource.testdistancecalculator.entities.DistanceInfo;

import java.util.List;

@Data
public class XmlData {

    private List<City> cities;

    private List<DistanceInfo> distanceInfos;
}
