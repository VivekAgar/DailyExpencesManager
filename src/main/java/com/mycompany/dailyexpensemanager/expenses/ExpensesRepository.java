package com.mycompany.dailyexpensemanager.expenses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ExpensesRepository extends CrudRepository<Expense, Long> {


}
