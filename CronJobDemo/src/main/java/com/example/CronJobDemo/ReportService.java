package com.example.CronJobDemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    public List<String> fetchReportData() {
        // Simulate fetching data from DB or external API
        return List.of("User A - 10 actions", "User B - 7 actions", "User C - 15 actions");
    }

    public void generateReport(List<String> data) {
        System.out.println("=== Daily Report ===");
        data.forEach(System.out::println);
        System.out.println("=====================");
    }
}
