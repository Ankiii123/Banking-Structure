import model.Account;
import repository.BankRepository;
import manager.BankManager;
import service.BankService;
import model.Accountinfo;
import model.Address;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Account A1 = new Account(new Accountinfo(1, format.parse("13/12/2023"), "A"), new Address("City-1", "State-1", 1), 123, BigDecimal.valueOf(0),601023);
        Account A2 = new Account(new Accountinfo(2, format.parse("13/12/2022"), "B"), new Address("City-2", "State-2", 2), 456, BigDecimal.valueOf(0),0);
        Account A3 = new Account(new Accountinfo(3, format.parse("13/12/2021"), "C"), new Address("City-3", "State-1", 3), 789, BigDecimal.valueOf(0),601024);

        BankManager bankManager = new BankManager();
        bankManager.addAccount(A1);
        bankManager.addAccount(A2);
        bankManager.addAccount(A3);
        bankManager.deposit(1, 100);
        bankManager.deposit(2, 30);
        bankManager.deposit(3,70);
        bankManager.withdraw(1, 20);
        bankManager.withdraw(2, 30);
        bankManager.withdraw(3,70);

        bankManager.getBalance(1);
        bankManager.getBalance(2);
        bankManager.getBalance(3);
    }

}