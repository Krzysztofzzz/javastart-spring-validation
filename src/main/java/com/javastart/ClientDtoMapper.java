package com.javastart;

import org.springframework.stereotype.Service;

@Service
public class ClientDtoMapper {
    Client map(ClientDto clientDto) {
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setAge(clientDto.getAge());
        return client;
    }
}
