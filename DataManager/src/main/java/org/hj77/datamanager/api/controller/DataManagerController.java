package org.hj77.datamanager.api.controller;

import lombok.RequiredArgsConstructor;
import org.hj77.datamanager.api.controller.dto.ClientDTO;
import org.hj77.datamanager.service.DataManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dm")
public class DataManagerController {

    private final DataManagerService dataManagerService;

    DataManagerController(DataManagerService dataManagerService) {
        this.dataManagerService = dataManagerService;
    }

    @PostMapping(value = "/client", consumes = "application/json")
    public String getClient(@RequestBody ClientDTO data){
        return dataManagerService.getClient(data.getId());
    }

    @PostMapping("/client/contact")
    public String getContact(){
        return dataManagerService.getContact();
    }

    @PostMapping("/client/account")
    public String getAccount(){
        return dataManagerService.getAccount();
    }

    @PostMapping("/client/account/balance")
    public String getBalance(){
        return dataManagerService.getBalance();
    }

    @PostMapping("/client/account/operation")
    public String getOperation(){
        return dataManagerService.getOperation();
    }

    @PostMapping("/client/contact/save")
    public String saveClient(){
        return dataManagerService.saveClient();
    }

    @PostMapping("/client/level")
    public String getLevel(){
        return dataManagerService.getLevel();
    }

    @PostMapping("/client/account/loan-payment")
    public String getLoanPayment(){
        return dataManagerService.getLoanPayment();
    }
}