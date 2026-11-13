package com.secure.service;

import com.secure.dto.FileRequestDto;
import com.secure.dto.FileResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApiGatewayService {

    public FileResponseDto getFileId(Long id ){
        return new FileResponseDto(
                1L,
                "1",
                "pdf",
                13L,
                LocalDate.now()
        );
    }

    public List<FileResponseDto> getAll(){
        return List.of();
    }
}
