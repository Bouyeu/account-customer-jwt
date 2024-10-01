package org.sylla.custumerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigTestController {

    @Value(value = "${global.params.p1}")
    private int p1;
    @Value(value = "${global.params.p2}")
    private int p2;
//    @Value(value = "${customer.params.x}")
//    private int x;
    @Value(value = """
            ${customer.params.y}""")
    private int y;
    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"y",y);
    }
}
