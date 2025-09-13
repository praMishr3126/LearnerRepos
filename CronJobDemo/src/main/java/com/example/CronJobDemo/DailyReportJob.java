package com.example.CronJobDemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DailyReportJob {

    private final ReportService reportService;

    public DailyReportJob(ReportService reportService) {
        this.reportService = reportService;
    }

    // Run every day at 2 AM
    @Scheduled(cron = "${report.job.cron}")
    public void executeDailyReportJob() {
        System.out.println("[Cron Job] Starting daily report generation...");

        List<String> reportData = reportService.fetchReportData();
        reportService.generateReport(reportData);

        System.out.println("[Cron Job] Report generation completed.");
    }
}
