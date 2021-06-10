package com.nishitpanchal395.costme;

import java.util.ArrayList;

public class List_addCustomers {
    public String customerName;
    public int customerNumber;
    public String customerLocation;
    public String customerPurchaseDate;
    public ArrayList<list_add_customers_others> add_customers_othersArrayList;
    public String customerPurchaseOtherProducts;
    public int TotalPrice;
    public int PaidAmount;
    public int DueAmount;
    public String LastSubmitDate;


    public List_addCustomers(String customerName1, int customerNumber1, String customerLocation1
            , String customerPurchaseDate1, ArrayList<list_add_customers_others> add_customers_othersArrayList1
            , String customerPurchaseOtherProducts1, int TotalPrice1, int PaidAmount1, int DueAmount1, String LastSubmitDate1) {
        customerName = customerName1;
        customerNumber = customerNumber1;
        customerLocation = customerLocation1;
        customerPurchaseDate = customerPurchaseDate1;
        add_customers_othersArrayList = add_customers_othersArrayList1;
        customerPurchaseOtherProducts = customerPurchaseOtherProducts1;
        TotalPrice = TotalPrice1;
        PaidAmount = PaidAmount1;
        DueAmount = DueAmount1;
        LastSubmitDate = LastSubmitDate1;
    }
}
