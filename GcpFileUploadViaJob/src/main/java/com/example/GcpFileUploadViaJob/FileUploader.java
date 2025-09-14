package com.example.GcpFileUploadViaJob;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/gcp")
public class FileUploader {

  @Autowired private Storage storage;

  @Value("{bucket.name}")
  private String bucketName;

  @Value("{file.path}")
  private String filePath;

  @Value("{file.name}")
  private String fileName;

  @PostMapping("/send-data")
  public void fileUpload() throws IOException {
    BlobId id = BlobId.of(bucketName, fileName);
    BlobInfo info = BlobInfo.newBuilder(id).build();

    File file = new File(filePath);

    byte[] arr = Files.readAllBytes(Paths.get(file.toURI()));
    storage.create(info, arr);
    log.info("File Uploaded succesfully");
  }
}
