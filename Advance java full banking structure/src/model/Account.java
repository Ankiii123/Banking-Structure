package model;

import java.math.BigDecimal;

public class Account {
    public Accountinfo accountinfo;
    Address address;
    int ph;
    BigDecimal balance;
    int aadhaar;

    public Account(Accountinfo accountinfo, Address address, int ph, BigDecimal balance, int aadhar) {
        this.accountinfo = accountinfo;
        this.address = address;
        this.ph = ph;
        this.balance = balance;
        this.aadhaar = aadhar;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void withdraw(double amount){
        synchronized (this) {
            if(balance.compareTo(BigDecimal.valueOf(amount)) >= 0) {
                balance = balance.subtract(BigDecimal.valueOf(amount));
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }
    public void penalty() {
        synchronized (this) {
            balance = balance.subtract(BigDecimal.valueOf(500));
        }
    }
    public void interest(){
        synchronized (this) {
            balance = balance.add(balance.multiply(BigDecimal.valueOf(0.06)));
        }
    }
    public void isKYCDone(){
        if(((Integer)aadhaar).equals(0)) {
            System.out.println("Your KYC is still not done");
        } else {
            System.out.println("Your KYC is done");
        }
    }

    public void deposit(double amount){
        synchronized (this) {
        balance = balance.add(BigDecimal.valueOf(amount));
        System.out.println("Current balance: " + balance);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountinfo=" + accountinfo +
                ", addr=" + address +
                ", ph=" + ph +
                ", balance=" + balance +
                ", aadhar=" + aadhaar +
                '}';
    }
}