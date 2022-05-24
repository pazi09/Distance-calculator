package magenta.datasource.testdistancecalculator.serviceInterface;

import magenta.datasource.testdistancecalculator.utils.XmlData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadServiceInterface {
    void uploadData(MultipartFile multipartFile) throws IOException;
    XmlData readData(MultipartFile file) throws IOException;
}
