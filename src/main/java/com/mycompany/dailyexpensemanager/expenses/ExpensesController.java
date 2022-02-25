package com.mycompany.dailyexpensemanager.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesController {

    @Autowired
    ExpensesService expenseService;


    @RequestMapping(method = RequestMethod.GET, value = "/allExpenses")
    public List<Expense> listAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @RequestMapping(
            value = "/expenses",
            params = "tag",
            method = RequestMethod.GET
    )
    public List<Expense> getExpensesByTag(@PathVariable String tag) {
        return expenseService.getExpenses(tag);
    }

    @RequestMapping(
            value  = "/expenses",
            params = "date",
            method = RequestMethod.GET
    )
    public List<Expense> getExpensesByDate(@RequestParam("date") String date) {
        return expenseService.getExpensesByDate(date);
    }

    @RequestMapping(
            value  = "/expenses",
            params = "paymentMethod",
            method = RequestMethod.GET
    )
    public List<Expense> getExpensesByPaymentMethod(@RequestParam("paymentMethod") String paymentMethod) {
        return expenseService.getExpensesByPaymentMethod(paymentMethod);
    }




}
