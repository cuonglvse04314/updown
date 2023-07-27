package com.example.springdemohelloworld.controller;

import com.example.springdemohelloworld.model.FileUploadResponse;
import com.example.springdemohelloworld.service.FileService;
import com.example.springdemohelloworld.service.ObjectMapperService;
import com.example.springdemohelloworld.util.FileDownloadUtil;
import com.example.springdemohelloworld.util.FileUploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

import static org.springframework.util.StringUtils.cleanPath;

@RestController
@AllArgsConstructor
public class TestMapper {

    ObjectMapperService objectMapperService;

    FileService fileService;

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(fileService.uploadFile(multipartFile), HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource;

        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

    @GetMapping("/object")
    public String testObject(String json, String date) {
        return objectMapperService.readValueObject(json, date);
    }
}
