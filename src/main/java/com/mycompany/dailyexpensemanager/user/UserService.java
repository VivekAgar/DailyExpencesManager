package com.mycompany.dailyexpensemanager.user;

import com.mycompany.dailyexpensemanager.expenses.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
        //return expenses.stream().sorted((o1, o2) -> o1.getDateString().compareTo(o2.getDateString())).collect(Collectors.toUnmodifiableList());
    }


}
