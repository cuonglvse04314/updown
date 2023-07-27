package com.example.springdemohelloworld.service.impl;

import com.example.springdemohelloworld.model.FileUploadResponse;
import com.example.springdemohelloworld.service.FileService;
import com.example.springdemohelloworld.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

import static org.springframework.util.StringUtils.cleanPath;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Override
    public FileUploadResponse uploadFile(MultipartFile multipartFile) throws IOException {
        String fileName = cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        long size = multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + fileCode);
        return response;
    }
}
