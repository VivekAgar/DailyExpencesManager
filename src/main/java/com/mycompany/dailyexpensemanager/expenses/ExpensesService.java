package com.mycompany.dailyexpensemanager.expenses;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpensesService {


    private List<Expense> expenses = Arrays.asList(
    //public Expense(float amount, String dateString, String tags, String description, String paymentMethod, String category) {
            new Expense(150, "01/02/2021", "Fuel", "Petrol", "Cash", "Fuel" , "Dolly Petroleum Noida"),
            new Expense(28, "01/02/2021", "Milk, Essentials", "Milk .5 L", "Cash", "Food" , "Mother Dairy 817 Sector 26"),
            new Expense(15929, "01/02/2021", "Insurance", "LIC Premium payment Vivek", "Kotalk net Banking", "Insurance" , "LIC of India"),
            new Expense(1272, "01/02/2021", "Travel, Train Ticket", "Ticket Durrnto Exp NZM to Kota Vivek", "Kotak Netbanking", "Travel" , "irctc.co.in"),
            new Expense(470, "26/02/2021", "Telephone, Mobile, Postpaid, Essentials ", "Vodafone postpaid Bill Payment", "UPI Google pay", "Communication" , "Vodafone Idea ltd"),
            new Expense(28, "02/02/2021", "Milk, Essentials", "Milk .5 L", "Cash", "Food" , "Mother Dairy 817 Sector 26 Noida"),
            new Expense(28, "03/02/2021", "Milk, Essentials", "Milk .5 L", "Paytm Food wallet", "Food" , "Mother Dairy 817 Sector 26 Noida"),
            new Expense(4625, "04/02/2021", "Electricity, Essentials ", "Electricity Bill Payment", "Cash", "Electricity" , "G D Bansal Noida"),
            new Expense(150, "13/02/2021", "Vegetables , Food ", "Spinach,Carrot, Beet roots, Gaurd, tomato", "Cash", "Food" , "Vegetables Vendor Manasa"),
            new Expense(150, "28/02/2021", "Vegetables , Food ", "Spinach,Carrot, Potato ", "Cash", "Food" , "Vegetables Vendor Manasa"),
            new Expense(208, "10/02/2021", "dryfruits, Food ", "Dried fig 250 g", "Cash", "Food" , "Mantri Brothers Manasa")
    );


    public List<Expense> getAllExpenses() {
        return expenses.stream().sorted((o1, o2) -> o1.getDateString().compareTo(o2.getDateString())).collect(Collectors.toUnmodifiableList());
    }


    public List<Expense> getExpenses(String tag) {
        return expenses.stream().filter((Expense e) -> e.getTags().contains(tag)).collect(Collectors.toUnmodifiableList());
    }


    public List<Expense> getExpensesByDate(String date) {
        return expenses.stream().filter(e-> e.getDateString().equalsIgnoreCase(date)).collect(Collectors.toUnmodifiableList());
    }

    public List<Expense> getExpensesByPaymentMethod(String paymentMethod) {
        return expenses.stream().filter(e-> e.getPaymentMethod().equalsIgnoreCase(paymentMethod)).toList();
    }
}
