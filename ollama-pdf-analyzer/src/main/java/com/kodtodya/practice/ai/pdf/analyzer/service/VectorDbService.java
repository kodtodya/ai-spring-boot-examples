package com.kodtodya.practice.ai.pdf.analyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
public class VectorDbService {
    @Value("vector-db.json")
    private String vectorDb;

    @Autowired
    private SimpleVectorStore vectorStore;

    public void generateEmbeddings(Resource resource) {

        log.info("----------------------vector initialized-----------------------");
        File vectorDbFile = getVectorDbFile();
        if (vectorDbFile.exists()) {
            vectorStore.load(vectorDbFile);
        } else {
            TextReader reader = new TextReader(resource);
            List<Document> documents = reader.get();
            TextSplitter textSplitter = new TokenTextSplitter();

            List<Document> splitDocuments = textSplitter.apply(documents);
            vectorStore.add(splitDocuments);
            vectorStore.save(vectorDbFile);
        }
        log.info("----------------------vector initialization completed-----------------------");
    }

    private File getVectorDbFile() {
        Path path = Paths.get("src", "main", "resources", "data");
        String absolutePath = path.toFile().getAbsolutePath() + "/" + vectorDb;
        return new File(absolutePath);
    }
}