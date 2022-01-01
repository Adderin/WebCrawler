//package cz.example.crawler.configuration;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DatasourceConfig {
//    @Bean
//    public DataSource datasource() {
//        return DataSourceBuilder.create()
//                .driverClassName("org.sqlite.JDBC")
//                .url("jdbc:sqlite:sample.db")
//                .username("sa")
//                .password("sa")
//                .build();
//    }
//}