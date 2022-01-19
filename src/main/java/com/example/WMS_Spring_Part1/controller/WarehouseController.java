package com.example.WMS_Spring_Part1.controller;

import com.example.WMS_Spring_Part1.Service.WarehouseService;
import com.example.WMS_Spring_Part1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
//Controller Layer
//add dependency injection for the WarehouseService class
/*create the following endpoints related to warehouse :

		- GET -> /warehouse/getWarehouses  -> returns Set<Integer>
		- GET -> /warehouse/getAllItems    -> returns List<Item>
		- GET -> /warehouse/getAllItems/{warehouseId} -> returns List<Item>
		- GET -> /warehouse/getCategories  -> returns Set<String>
		- GET -> /warehouse/getItemsByCategory/{category}  -> returns List<Item>*/
@RestController
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehouse/getWarehouses")
    public Set<Integer> getWarehouses() {
        return warehouseService.getWarehouses();
    }
    @GetMapping("/warehouse/getAllItems")
    public List<Item> getAllItems(){
        return warehouseService.getAllItems();
    }
    @GetMapping("/warehouse/getAllItems/{warehouseId}")
    public List<Item> getItemsByWarehouse(@PathVariable int warehouse){
        return warehouseService.getItemsByWarehouse(warehouse);
    }
    @GetMapping("/warehouse/getCategories")
    public Set<String> getCategories(){
        return warehouseService.getCategories();
    }
    @GetMapping("/warehouse/getItemsByCategory/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category){
        return warehouseService.getItemsByCategory(category);
    }

}
