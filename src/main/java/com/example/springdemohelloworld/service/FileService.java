package com.example.springdemohelloworld.service;

import com.example.springdemohelloworld.model.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileUploadResponse uploadFile(MultipartFile multipartFile) throws IOException;
}
