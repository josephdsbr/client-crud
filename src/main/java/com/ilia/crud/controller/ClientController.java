package com.ilia.crud.controller;

import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.pojo.Client;
import com.ilia.crud.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ClientController {
  private final ClientService clientService;

  @PostMapping
  public ResponseEntity<Client> handleUserCreation(
      @RequestBody ClientDTO clientDTO
      ) {
    try {
      Client client = this.clientService.createClient(clientDTO);
      return new ResponseEntity<>(client, HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }


}
