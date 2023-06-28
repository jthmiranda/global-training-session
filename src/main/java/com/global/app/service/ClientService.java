package com.global.app.service;

import com.global.app.models.Client;
import com.global.app.repositoty.ClientRepository;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client findId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
