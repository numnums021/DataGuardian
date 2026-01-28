package org.hj77.crmbusinesshub.api.controller;

import org.hj77.crmbusinesshub.service.HubService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ImplClientController implements IClientController {

    private final HubService hubService;

    ImplClientController(HubService hubService){
        this.hubService = hubService;
    }

    @PostMapping("/client")
    public String getClient(@RequestBody String str){
        return hubService.getClient();
    }

    @PostMapping("/client/find")
    public String findClient(@RequestBody String str){
        return hubService.findClient();
    }

    @PostMapping("/client/account/last-operations")
    public String lastOperations(@RequestBody String str){
        return hubService.lastOperations();
    }

    @PostMapping("client/contact/save")
    public String saveClient(@RequestBody String str){
        return hubService.saveClient();
    }

    @PostMapping("client/level")
    public String clientLevel(@RequestBody String str){
        return hubService.level();
    }

    @PostMapping("client/account/loan-payment")
    public String clientLoanPayment(@RequestBody String str){
        return hubService.loanPayment();
    }
}
