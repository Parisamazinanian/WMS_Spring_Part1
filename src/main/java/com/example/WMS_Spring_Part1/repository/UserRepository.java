package com.example.WMS_Spring_Part1.repository;
import com.example.WMS_Spring_Part1.model.Admin;
import com.example.WMS_Spring_Part1.model.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Data Repository
 *
 * @author pujanov
 *
 */
public class UserRepository {
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<Employee>();
    private static List<Admin> ADMIN_LIST = new ArrayList<Admin>();

    /**
     * Load employee, records from the personnel.json file
     */
    static {
        // System.out.println("Loading items");
        BufferedReader reader = null;
        try {
            EMPLOYEE_LIST.clear();

            reader = new BufferedReader(new FileReader("/Users/temporaryadmin/Documents/DCI/java-projects-individual-2_java-basics-6_functions-Parisamazinanian/SpringInitializr/WMS_Spring_Part1/data/personnel.json"));
            Object data = JSONValue.parse(reader);
            if (data instanceof JSONArray) {
                JSONArray dataArray = (JSONArray) data;
                for (Object obj : dataArray) {
                    if (obj instanceof JSONObject) {
                        JSONObject jsonData = (JSONObject) obj;
                        String userName = jsonData.get("user_name").toString();
                        String password = jsonData.get("password").toString();
                        String role = jsonData.get("role").toString();
                        if (role.equalsIgnoreCase("EMPLOYEE")) {
                            Employee employee = new Employee(userName, password, null);
                            EMPLOYEE_LIST.add(employee);
                        } else if (role.equalsIgnoreCase("admin")) {
                            Admin admin = new Admin(userName, password);
                            ADMIN_LIST.add(admin);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * Get All persons
     *
     * @return
     */
    public static List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }


    public static boolean isEmployeeValid(String userName, String password) {
        List<Employee> employees = getAllEmployees();

        for (Employee employee : employees) {
            if (userName.equals(employee.getName())) {
                if (password.equals(employee.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUserEmployee(String name) {
        //to implement
        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static List<Admin> getAllAdmins() {
        return ADMIN_LIST;
    }
    public static boolean isAdminValid(String userName, String password) {
        List<Admin> admins = getAllAdmins();

        for (Admin admin : admins) {
            if (userName.equals(admin.getName())) {
                if (password.equals(admin.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUserAdmin(String name) {
        //to implement
        for (Admin admin : ADMIN_LIST) {
            if (admin.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
