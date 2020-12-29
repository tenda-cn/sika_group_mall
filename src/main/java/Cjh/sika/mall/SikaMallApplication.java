package Cjh.sika.mall;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("Cjh.sika.mall.dao")
@SpringBootApplication
public class SikaMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(SikaMallApplication.class, args);
    }
}
