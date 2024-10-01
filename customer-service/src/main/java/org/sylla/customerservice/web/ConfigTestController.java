package org.sylla.customerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sylla.customerservice.config.GlobalConfig;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value(value = "${global.params.p1}")
    private int p1;
    @Value(value = "${global.params.p2}")
    private int p2;
    @Value(value = "${customer.params.x}")
    private int x;
    @Value(value = "${customer.params.y}")
    private int y;

    @Autowired
    private GlobalConfig globalConfig;


    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    @GetMapping("/GlobalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
