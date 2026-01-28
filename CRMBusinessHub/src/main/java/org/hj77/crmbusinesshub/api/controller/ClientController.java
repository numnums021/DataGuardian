package org.hj77.crmbusinesshub.api.controller;

import org.hj77.crmbusinesshub.service.HubService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final HubService hubService;

    ClientController(HubService hubService){
        this.hubService = hubService;
    }

    @PostMapping("/client")
    public String getClient(@RequestBody String str){
        System.out.println("123");
        return hubService.getClient();
    }

    @PostMapping("/client/account/last-operations")
    public String findClient(@RequestBody String str){
        return hubService.findClient();
    }

    @PostMapping("client/level")
    public String level(@RequestBody String str){
        return hubService.level();
    }
}
