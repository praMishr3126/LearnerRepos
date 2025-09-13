package com.example.GcpFileUploadViaJob;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;

@Component
public class ExcelUploadJob {

    @Autowired
    private Storage storage;

    private static final String BUCKET_NAME = "my-gcp-bucket-76";
    private static final String FILE_NAME = "generated-data.xlsx";

    @Scheduled(cron = "0 0/1 * * * *") // Runs every 1 minute
    public void generateAndUploadExcel() throws IOException {
        // 1. Create Excel workbook in memory
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // 2. Add header and some sample data
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Timestamp");

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(1);
        dataRow.createCell(1).setCellValue("Sample Data");
        dataRow.createCell(2).setCellValue(new Date().toString());

        // 3. Write Excel file to temporary file
        File tempFile = File.createTempFile("data-", ".xlsx");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            workbook.write(fos);
        }

        // 4. Upload to GCS
        byte[] bytes = Files.readAllBytes(tempFile.toPath());
        BlobId blobId = BlobId.of(BUCKET_NAME, FILE_NAME);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, bytes);

        System.out.println("✅ Excel file uploaded to GCS successfully.");

        // 5. Cleanup
        tempFile.delete();
        workbook.close();
    }
}
