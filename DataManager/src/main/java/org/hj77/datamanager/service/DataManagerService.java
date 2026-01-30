package org.hj77.datamanager.service;

import org.hj77.datamanager.repository.entity.Client;
import org.hj77.datamanager.repository.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataManagerService {

    private final ClientService clientService;

    DataManagerService(ClientService clientService) {
        this.clientService = clientService;
    }

    public String getClient(String id) {
        return clientService.findById(id)
                            .map(Client::toString)
                            .orElse("Клиент не найден");
    }

    public String getContact() {
        return "";
    }

    public String getAccount() {
        return "";
    }

    public String getBalance() {
        return "";
    }

    public String getOperation() {
        return "";
    }

    public String saveClient() {
        return "";
    }

    public String getLevel() {
        return "";
    }

    public String getLoanPayment() {
        return "";
    }
}