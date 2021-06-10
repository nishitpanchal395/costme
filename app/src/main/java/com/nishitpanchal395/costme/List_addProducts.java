package com.nishitpanchal395.costme;

import java.util.Date;

public class List_addProducts {




    public String ProductName;
    public String BrandName;
    public int Quantity;
    public String Location;
    public String date;
    public int  CustomerPrice;
    public int CustomerLastPrice;
    public int OurPrice;
    public String DealerName;
    public String DealerShopName;
    public String  DealerNumber;

    public List_addProducts(String ProductName1, String BrandName1, int Quantity1,
                            String Location1, String  date1, int CustomerPrice1,
                            int CustomerLastPrice1, int OurPrice1, String DealerName1,
                            String DealerNumber1, String DealerShopName1) {
        ProductName = ProductName1;
        BrandName = BrandName1;
        Quantity = Quantity1;
        Location = Location1;
        date = date1;
        CustomerPrice = CustomerPrice1;
        CustomerLastPrice = CustomerLastPrice1;
        OurPrice = OurPrice1;
        DealerName = DealerName1;
        DealerShopName = DealerShopName1;
        DealerNumber = DealerNumber1;


    }




}
