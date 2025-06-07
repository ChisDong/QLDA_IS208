package com.hctt.is208.candidate;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/{id}/upload-cv")
    public   ResponseEntity<String> uploadCv(@PathVariable int id, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        try {
            candidateService.saveFile(file);
            return ResponseEntity.ok("CV uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload CV: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/list-cv")
    public ResponseEntity<?> listFiles(@PathVariable int id) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of("C:\\Storage"))) {
            var files = StreamSupport.stream(stream.spliterator(), false)
                            .map(Path::getFileName)
                            .map(Path::toString)
                            .collect(Collectors.toList());
            return ResponseEntity.ok(files);
        }
    }

    @GetMapping("/{id}/download-cv")
    public ResponseEntity<Resource> downloadCV(@PathVariable int id, @RequestParam("fileName") String fileName) {
        try {
            var fileToDownload = candidateService.getDownloadCV(id, fileName);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileToDownload.getName() + "\"")
                    .contentLength(fileToDownload.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new FileSystemResource(fileToDownload));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
