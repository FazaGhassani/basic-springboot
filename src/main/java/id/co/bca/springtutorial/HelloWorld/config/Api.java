package id.co.bca.springtutorial.HelloWorld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

//class ini digunakan untuk memudahkan kita memanggil data dari application.properties
//maka dibikin 1 class untuk class penerimanya
@Configuration //dibaca di @EnableAutoConfiguration
@ConfigurationProperties("api") //kalau misalkan ada error "Spring Boot Configuration Annotation Processor not configured" padahal di pom.xml nya udah di tambahin. install lalu reload metadatanya maven
public class Api {
    private String url;
    private String dataType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
