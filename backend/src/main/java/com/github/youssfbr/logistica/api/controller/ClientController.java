package com.github.youssfbr.logistica.api.controller;

import com.github.youssfbr.logistica.domain.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @GetMapping
    public ResponseEntity<List<Client>> test() {
        
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("Alisson Youssf");
        client1.setPhone("(85) 98999-9999");
        client1.setEmail("youssfbr@gmail.com");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Link da Silva");
        client2.setPhone("(85) 98999-9991");
        client2.setEmail("link@gmail.com");

        return ResponseEntity.ok(Arrays.asList(client1, client2));
    }
}
