package com.MikalaSbDeathrun.MikailaHw.App;
import com.MikalaSbDeathrun.MikailaHw.bs.Idek;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import  java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

//the code jedi
import java.util.Arrays;
@EnableScheduling

@SpringBootApplication
public class CripsTowApp {

    private static final Logger shlog = LoggerFactory.getLogger(CripsTowApp.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        SpringApplication.run(CripsTowApp.class, args);
    }

 @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
 }


 @Bean
 public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
     return args -> {
issaTimer();
     };





 }


    @Scheduled(fixedRate = 3000)
    public void issaTimer(){
        RestTemplate restTemplate = new RestTemplate();
        Idek [] theones = restTemplate.getForObject(
                "https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?format=json&market_code=nex"       , Idek[].class );
        shlog.info(Arrays.toString(theones));
        shlog.info("John Cena Intro {}", dateFormat.format(new Date()));

    }


}
