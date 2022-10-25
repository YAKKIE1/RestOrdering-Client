/*
TableFactory.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Tablee;
import za.ac.cput.util.LoginHelper;

public class TableFactory {
public static Tablee createTable (String tableId, String tableNo, String noOfSeats, boolean isTableAvailable){
 LoginHelper.checkStringParam("Table Id",tableId);
 LoginHelper.checkStringParam("Table Number",tableNo);
 LoginHelper.checkStringParam("Number Of Seats",noOfSeats);
 LoginHelper.checkIfObjectNull("is Table Available", isTableAvailable);


 return new Tablee.Builder().setTableId(tableId).setTableNo(tableNo).setNoOfSeats(noOfSeats).setTableAvailable(isTableAvailable).build();
}
}
