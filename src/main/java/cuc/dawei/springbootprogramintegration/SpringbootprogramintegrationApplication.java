package cuc.dawei.springbootprogramintegration;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, MybatisAutoConfiguration.class})
@MapperScan(value = "cuc.dawei.springbootprogramintegration.mapper")
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootprogramintegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootprogramintegrationApplication.class, args);
    }

}
