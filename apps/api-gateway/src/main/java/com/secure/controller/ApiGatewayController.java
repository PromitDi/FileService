package com.secure.controller;

import com.secure.dto.FileResponceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ApiGatewayController {

    private final Logger log = LoggerFactory.getLogger(ApiGatewayController.class);

    @GetMapping
    public List<FileResponceDto> getAllFiles(){
        return List.of();

    }
}
