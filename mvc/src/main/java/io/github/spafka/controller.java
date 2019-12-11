package io.github.spafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @Autowired
    B b;

    @ResponseBody
    @GetMapping("v")
    public String van() {

        return "v";
    }
}
