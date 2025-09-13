package com.example.MissedPymtApplication;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserPaymentRepository {
    public List<UserPayment> findDueDateBeforeAndPaidFalse(LocalDate today);
}
