package com.secure.controller;

import com.secure.dto.FileResponseDto;
import com.secure.service.ApiGatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/files")
public class ApiGatewayController {

    private final ApiGatewayService service;

    public ApiGatewayController(ApiGatewayService service) {
        this.service = service;
    }

    @GetMapping
    public List<FileResponseDto> getAllFiles(){
        return service.getAll();

    }

    @GetMapping("{id}")
    public FileResponseDto getFileId(
            @PathVariable
            Long id
    ){
        return service.getFileId(id);

    }
}
