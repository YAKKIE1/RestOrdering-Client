package za.ac.cput.factory;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.domain.Inventory;
import za.ac.cput.util.LoginHelper;

public class InventoryFactory {

    public static Inventory createInventory(String inv, String itemName, String category, String vendor, String vendorInv, String vendorPrice){
        Inventory inventory = new Inventory.Builder().setInv(inv)
                .setCategory(category)
                .setItemName(itemName)
                .setVendor(vendor)
                .setVendorInv(vendorInv)
                .setVendorPrice(vendorPrice)
                .build();
        LoginHelper.checkStringParam("inv",inv);
        LoginHelper.checkStringParam("Item Name",itemName);
        LoginHelper.checkStringParam("Category",category);
        LoginHelper.checkStringParam("Vendor",vendor );
        LoginHelper.checkStringParam("Vendor inventory ",vendorInv);
        return inventory;
    }
}
