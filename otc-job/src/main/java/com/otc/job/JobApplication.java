package com.otc.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
    {"com.otc.job","com.otc.common"})
public class JobApplication {
  public static void main(String[] args) {
    SpringApplication.run(JobApplication.class, args);
  }
}
