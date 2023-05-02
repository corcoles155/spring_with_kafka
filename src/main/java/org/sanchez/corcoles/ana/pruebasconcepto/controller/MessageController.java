package org.sanchez.corcoles.ana.pruebasconcepto.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sanchez.corcoles.ana.pruebasconcepto.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @ApiOperation(value = "send message")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok")
    })
    @GetMapping()
    public ResponseEntity<Void> send(@RequestBody String message) {
        service.send(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
