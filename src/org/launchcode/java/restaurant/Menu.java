package org.launchcode.java.restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jen Kocher on 4/22/2017.
 */

public class Menu {
    private ArrayList<MenuItem> menuItems;
    private Date dateChanged;

    public Menu(){
        this.menuItems = new ArrayList<MenuItem>();
        //this.dateChanged = new Date();
        this.dateChanged = Calendar.getInstance().getTime();
    }

    public void addMenuItem(MenuItem aMenuItem){
        menuItems.add(aMenuItem);
        dateChanged = Calendar.getInstance().getTime();
    }

    public int removeMenuItem(String aDescription){
        return 0;
    }

    //public void setDateChanged(Date aDate){
    //    dateChanged = aDate;
    //}

    public Date getDateChanged() {
        return dateChanged;
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }
}