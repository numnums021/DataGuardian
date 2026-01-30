package org.hj77.datamanager.repository.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hj77.datamanager.repository.entity.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Service
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Optional<Client> findById(String id) {
        return Optional.ofNullable(entityManager.find(Client.class, id));
    }
}
