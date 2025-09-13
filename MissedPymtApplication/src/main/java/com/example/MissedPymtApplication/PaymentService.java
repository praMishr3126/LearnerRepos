package com.example.MissedPymtApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private UserPaymentRepository paymentRepository;

    public List<UserPayment> getMissedPayments(){
        LocalDate today = LocalDate.now();
        return paymentRepository.findDueDateBeforeAndPaidFalse(today);
    }
}
