package io.github.spafka;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @ResponseBody
    @GetMapping("v")
    public String van() {

        return "v";
    }
}
