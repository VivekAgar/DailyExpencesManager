package com.mycompany.dailyexpensemanager;

import com.mycompany.dailyexpensemanager.expenses.ExpensesRepository;
import com.mycompany.dailyexpensemanager.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DailyExpenseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyExpenseManagerApplication.class, args);
	}

}
