package com.example.MissedPymtApplication;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class UserPayment {

  private boolean paid;
  private LocalDate dueDate;
  private Long userid;
  private Long id;
}
