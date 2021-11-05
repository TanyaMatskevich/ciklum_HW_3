package com.ciklum.ciklumwebhw3;

import com.ciklum.ciklumwebhw3.servlet.ProductServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:config.xml")
@ServletComponentScan
@SpringBootApplication
public class Ciklumwebhw3Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Ciklumwebhw3Application.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Ciklumwebhw3Application.class);
    }

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(
//                new ProductServlet(), "/ProductServlet");
//    }
}
