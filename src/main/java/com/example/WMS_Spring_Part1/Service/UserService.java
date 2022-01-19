package com.example.WMS_Spring_Part1.Service;

import com.example.WMS_Spring_Part1.model.Admin;
import com.example.WMS_Spring_Part1.model.Employee;
import com.example.WMS_Spring_Part1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //delegating the functionalities from your UserRespository class


    public List<Employee> getAllEmployees(){
        return UserRepository.getAllEmployees();
    }

    public List<Admin> getAllAdmins(){
        return UserRepository.getAllAdmins();
    }

    public boolean isEmployeeValid(String name, String password){
        return UserRepository.isEmployeeValid(name, password);
    }

    public boolean isAdminValid(String name, String password){
        return UserRepository.isAdminValid(name, password);
    }

}
