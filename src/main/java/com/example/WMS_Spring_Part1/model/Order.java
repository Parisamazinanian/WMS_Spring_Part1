package com.example.WMS_Spring_Part1.model;

import java.util.Date;
import java.util.List;

public class Order {
    private String status;
    private boolean isPaymentDone;
    private int warehouse;
    Date dateOfOrder;
    private List<OrderItem> orderItems;
    private double totalCost;

    public Order(String status, boolean isPaymentDone, int warehouse, Date dateOfOrder, List<OrderItem> orderItems, double totalCost) {
        this.status = status;
        this.isPaymentDone = isPaymentDone;
        this.warehouse = warehouse;
        this.dateOfOrder = dateOfOrder;
        this.orderItems = orderItems;
        this.totalCost = totalCost;
    }
}
