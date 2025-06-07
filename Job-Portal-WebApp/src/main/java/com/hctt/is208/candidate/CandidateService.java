package com.hctt.is208.candidate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    private static final String CV_STORAGE_DIR = "C:\\Storage";

    public void saveFile(MultipartFile file) {
        if (file == null)
            throw new NullPointerException("There's no file to save");
        var targetFile = new File(CV_STORAGE_DIR + File.separator + file.getOriginalFilename());
        if (!Objects.equals(targetFile.getParent(), CV_STORAGE_DIR)) {
            throw new SecurityException("Unsported filename!");
        }
        try {
            Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }



    public File getDownloadCV(String fileName) throws Exception{
        if (fileName == null || fileName.isEmpty()) {
            throw new NullPointerException("File name cannot be null or empty");
        }

        var fileToDownload = new File(CV_STORAGE_DIR + File.separator + fileName);
        if (!Objects.equals(fileToDownload.getParent(), CV_STORAGE_DIR)) {
            throw new SecurityException("Unsported filename!");
        }

        if(!fileToDownload.exists()) {
            throw new RuntimeException("File not found: " + fileName);
        }

        return fileToDownload;
    }
}
