package com.mycompany.dailyexpensemanager.expenses;

import com.mycompany.dailyexpensemanager.user.User;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


@Entity
@Table(name="expenses")
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User userDetails;

    private float amount;
    private String dateString;
    private String tags;
    private String description;
    private String merchant;
    private String paymentMethod;
    private String category;

    public Expense(){

    }

    public Expense(float amount, String dateString, String tags, String description, String paymentMethod, String category, String merchant) {

        //this.id = UUID.randomUUID();
        this.amount = amount;
        this.dateString = dateString;
        this.tags = tags;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.merchant = merchant;
    }


    public Expense(float amount, String dateString, String tags, String description, String paymentMethod, String category, String merchant, User userDetails) {

        this.userDetails = userDetails;
        this.amount = amount;
        this.dateString = dateString;
        this.tags = tags;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.merchant = merchant;
    }


    public Long getId() {
        return id;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
