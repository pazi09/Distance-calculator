package magenta.datasource.testdistancecalculator.serviceInterface;

import magenta.datasource.testdistancecalculator.utils.XmlData;

import java.io.IOException;

public interface UploadServiceInterface {
    void uploadData() throws IOException;
    XmlData readData() throws IOException;
}
