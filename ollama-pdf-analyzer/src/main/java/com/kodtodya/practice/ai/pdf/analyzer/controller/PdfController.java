package com.kodtodya.practice.ai.pdf.analyzer.controller;

import com.kodtodya.practice.ai.pdf.analyzer.service.VectorDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private VectorDbService vectorDbService;

    @PostMapping("/read-resource")
    public ResponseEntity<String> readPdfResource() {
        // Load PDF as a resource
        ClassPathResource resource = new ClassPathResource("content.pdf");
        vectorDbService.generateEmbeddings(resource);
        return ResponseEntity.ok("File is loaded to RAG.");
    }
}
