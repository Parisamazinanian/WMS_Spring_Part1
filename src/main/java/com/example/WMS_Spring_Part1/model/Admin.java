package com.example.WMS_Spring_Part1.model;

public class Admin extends Employee{
    private String password;

    public Admin(String userName){
        super(userName);
    }
    public Admin(String userName, String password){
        super(userName);
        this.password = password;
    }
    @Override
    public void greet(){
        System.out.println("Hello,"+ super.name+" !\n Welcome to the Admin Panel.\n" +
"With higher authority comes higher responsibility." );

    }
}
