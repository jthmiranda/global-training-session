package com.global.app.controllers;

import com.global.app.models.Client;
import com.global.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/listar")
    public String listar(Model model) {
        List<Client> clientes = service.findAll();
        model.addAttribute("clients", clientes);
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(Client client) {
        service.save(client);
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Client client = null;
        if (id > 0) {
            client = service.findId(id);
        }
        model.addAttribute("client", client);
        return "form";
    }

    @RequestMapping(value = "/delete/{id}")
    public String remove(@PathVariable Long id) {
        if (id > 0) {
            service.remove(id);
        }
        return "redirect:/listar";
    }

}
