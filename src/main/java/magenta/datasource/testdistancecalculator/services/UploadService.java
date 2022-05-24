package magenta.datasource.testdistancecalculator.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import magenta.datasource.testdistancecalculator.entities.City;
import magenta.datasource.testdistancecalculator.entities.DistanceInfo;
import magenta.datasource.testdistancecalculator.repository.CityRepository;
import magenta.datasource.testdistancecalculator.repository.DistanceRepository;
import magenta.datasource.testdistancecalculator.serviceInterface.UploadServiceInterface;
import magenta.datasource.testdistancecalculator.utils.XmlData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UploadService implements UploadServiceInterface {

    CityRepository cityRepository;
    DistanceRepository distanceRepository;

    public UploadService(CityRepository cityRepository, DistanceRepository distanceRepository){
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    public void uploadData(MultipartFile file) throws IOException {
        XmlData data = readData(file);
        List<City> cities = data.getCities();
        List<DistanceInfo> distanceInfos = data.getDistanceInfos();
        for (City city : cities) {
            if(cityRepository.findByName(city.getName()) == null) {
                cityRepository.save(city);
            }
            else{
                System.out.println("City already exists");
            }
        }
        for (DistanceInfo distance : distanceInfos) {
            if(distanceRepository.findByFromCityAndToCity(distance.getFromCity(), distance.getToCity()) == null) {
                distanceRepository.save(distance);
            }
            else{
                System.out.println("Distance already measured");
            }
        }
    }

    public XmlData readData(MultipartFile file) throws IOException {
        ObjectMapper mapper = new XmlMapper();

        String readContent = new String(file.getBytes());

        XmlData data = mapper.readValue(readContent, XmlData.class);
//            List<City> cities = Arrays.asList(mapper.readValue(readContent, City[].class));
//            ObjectMapper mapper1 = new XmlMapper();
//            List<DistanceInfo> distanceInfos = Arrays.asList(mapper1.readValue(readContent, DistanceInfo[].class));
        return data;
    }


}
