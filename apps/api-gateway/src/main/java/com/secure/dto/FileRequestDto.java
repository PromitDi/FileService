package com.secure.dto;

import java.time.LocalDate;

public record FileRequestDto(
        Long fileId,
        String fileName,
        String fileType,
        Long fileSize,
        LocalDate createdDate
) {
}
