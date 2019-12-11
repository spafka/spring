package io.github.spafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }



    @ResponseBody
    @GetMapping
    public String van(){

        return "v";
    }

}
