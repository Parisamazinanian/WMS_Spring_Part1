package com.example.WMS_Spring_Part1.model;

import java.util.List;

public class Guest extends User{


    public Guest(String userName) {
        super(userName);
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void greet(){
        System.out.println("Hello, "+ this.name +"!\n"+
                "Welcome to our Warehouse Database.\n If you don't find what you are looking for," +
                "\nplease ask one of our staff members to assist you.");

    }
@Override
    public void bye(List<String> actions){
        System.out.println("Thank you for your visit, "+this.name+" !");

    }
}
