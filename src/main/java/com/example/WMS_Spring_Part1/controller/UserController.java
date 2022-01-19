package com.example.WMS_Spring_Part1.controller;

import com.example.WMS_Spring_Part1.Service.UserService;
import com.example.WMS_Spring_Part1.model.Admin;
import com.example.WMS_Spring_Part1.model.Employee;
import com.example.WMS_Spring_Part1.model.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//Controller Layer
//add dependency injection for the UserService class
/*      - GET -> /users/getAllEmployees  -> returns List<Employee>
		- GET -> /users/getAllAdmins    -> returns List<Admin>*/
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return userService.getAllEmployees();
    }
    @GetMapping("/users/getAllAdmins")
    public List<Admin> getAllAdmins(){
        return userService.getAllAdmins();
    }
    //Using LoginDTO as a RequestBody
    //Check if the employee login infos are correct
    @GetMapping("/users/employee/login")
    public boolean isUserEmployee(@RequestBody LoginDTO loginDTO){
        return userService.isEmployeeValid(loginDTO.getUsername(), loginDTO.getPassword());
    }
    //check if the admin login infos are correct
    @GetMapping("/users/admin/login")
    public boolean isAdminValid(@RequestBody LoginDTO loginDTO){
        return userService.isAdminValid(loginDTO.getUsername(), loginDTO.getPassword());
    }


}
