package com.secure.dto;

import java.time.LocalDate;

public record FileResponseDto(
        Long fileid,
        String fileName,
        String fileType,
        Long fileSize,
        LocalDate createdDate
) {
}
