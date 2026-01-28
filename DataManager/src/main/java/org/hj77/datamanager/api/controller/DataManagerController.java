package org.hj77.datamanager.api.controller;

import org.hj77.datamanager.service.DataManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dm")
public class DataManagerController {

    DataManagerService dataManagerService;

    @PostMapping("/client")
    public String getClient(){
        return dataManagerService.getClient();
    }

    @PostMapping("/client/contract")
    public String getContract(){
        return dataManagerService.getConctract();
    }

    @PostMapping("/client/account")
    public String getAccount(){
        return dataManagerService.getAccount();
    }
}