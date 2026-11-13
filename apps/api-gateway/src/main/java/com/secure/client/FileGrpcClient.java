package com.secure.client;

import com.secure.fileservice.grpc.*;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class FileGrpcClient {

    // Имя в кавычках должно совпадать с ключом из application.yml
    @GrpcClient("file-query-service")
    private FileQueryServiceGrpc.FileQueryServiceBlockingStub fileQueryStub;

    public List<FileMetadataResponse> getAllFiles() {
        try {
            // 1. Собираем объект запроса (даже если он пустой)
            GetAllFilesRequest request = GetAllFilesRequest.newBuilder().build();

            // 2. Отправляем запрос с ограничением по времени (таймаут 3 секунды)
            FileListResponse response = fileQueryStub
                    .withDeadlineAfter(3, TimeUnit.SECONDS)
                    .getAllFiles(request);

            // 3. Достаем список файлов из ответа
            return response.getFilesList();
        } catch (StatusRuntimeException e) {
            throw e;
        }
    }

    // Запрос №2: получить ссылку на скачивание по ID файла
    public String getDownloadUrl(UUID fileId) {
        try {
            // 1. Собираем запрос и передаем туда ID в виде строки
            GetDownloadUrlRequest request = GetDownloadUrlRequest.newBuilder()
                    .setFileId(fileId.toString())
                    .build();

            // 2. Вызываем удаленный метод
            DownloadUrlResponse response = fileQueryStub
                    .withDeadlineAfter(3, TimeUnit.SECONDS)
                    .getDownloadUrl(request);

            // 3. Возвращаем строку со ссылкой
            return response.getDownloadUrl();
        } catch (StatusRuntimeException e) {
            throw e;
        }
    }
}
