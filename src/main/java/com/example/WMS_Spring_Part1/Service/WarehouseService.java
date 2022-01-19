package com.example.WMS_Spring_Part1.Service;

import com.example.WMS_Spring_Part1.model.Item;
import com.example.WMS_Spring_Part1.model.Warehouse;
import com.example.WMS_Spring_Part1.repository.UserRepository;
import com.example.WMS_Spring_Part1.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.WMS_Spring_Part1.repository.WarehouseRepository.WAREHOUSE_LIST;


@Service
public class WarehouseService {

    //delegating the functionalities from your WarehouseRespository class

    public Set<Integer> getWarehouses() {
        return WarehouseRepository.getWarehouses();
    }

    public List<Item> getAllItems(){
        return WarehouseRepository.getAllItems();
    }

    public List<Item> getItemsByWarehouse(int warehouse){
        return WarehouseRepository.getItemsByWarehouse(warehouse);
    }
    public Set<String> getCategories(){
        return WarehouseRepository.getCategories();
    }
    public List<Item> getItemsByCategory(String category){
        return WarehouseRepository.getItemsByCategory(category);
    }

}
