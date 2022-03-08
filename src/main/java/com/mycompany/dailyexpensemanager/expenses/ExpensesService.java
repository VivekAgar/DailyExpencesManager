package com.mycompany.dailyexpensemanager.expenses;


import com.mycompany.dailyexpensemanager.exception.DailyExpenseManagerException;
import com.mycompany.dailyexpensemanager.user.User;
import com.mycompany.dailyexpensemanager.user.UserRepository;
import com.mycompany.dailyexpensemanager.utility.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpensesService {

    @Autowired
    ExpensesRepository expensesRepository;

    @Autowired
    UserRepository userRepository;

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
        List<Expense> expenses = new ArrayList();
        expensesRepository.findAll().forEach(expense -> expenses.add(expense));
        return expenses;
        //return expenses.stream().sorted((o1, o2) -> o1.getDateString().compareTo(o2.getDateString())).collect(Collectors.toUnmodifiableList());
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

//    public void addExpense(Expense expense){
//        expensesRepository.save(expense);
//
//    }
    public String addExpense(Long userId, Expense expense){

        //Validate user
        User  user = validateUser(userId);
        //validate input fields

        //save
        saveExpense(user, expense);
        return "added successfully";
    }

    private User validateUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DailyExpenseManagerException(ApplicationConstants.VALIDATION_USER_ID));
    }


    private String saveExpense(User user, Expense expense) {
        Expense expenseEntry = new Expense(expense.getAmount(), expense.getDateString(), expense.getTags(), expense.getDescription(), expense.getPaymentMethod(), expense.getCategory(), expense.getMerchant(), user);
        expensesRepository.save(expenseEntry);
        return ApplicationConstants.ADDED_DESC;
    }



}
