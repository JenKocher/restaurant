package org.launchcode.java.restaurant;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jen on 4/22/2017.
 */
public class MenuItem {

    static ArrayList<String> categories = new ArrayList<String>(
            Arrays.asList("appetizer", "main course", "dessert"));

    private String category;
    private String description;
    private Double price;
    private Date dateCreated;

    public MenuItem() {
        this.category = null;
        this.description = null;
        this.price = 0.00;
        this.dateCreated = Calendar.getInstance().getTime();
    }

    public MenuItem(String aCategory,
                    String aDescription,
                    Double aPrice) {
        this.category = aCategory;
        this.description = aDescription;
        this.price = aPrice;
        this.dateCreated = Calendar.getInstance().getTime();
    }


    public void setCategory(String aCategory) {
        category = aCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(Double aPrice) {
        price = aPrice;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date aDateCreated) {
        dateCreated = aDateCreated;
    }

    @Override
    public String toString() {
        String out;
        String isNew = "";
        long result;
        result = getDifferenceDays(dateCreated, Calendar.getInstance().getTime());
        if (result < 259200000){
            isNew = "New Item!";
        }
        out = "Category: " + category + "\n" + "Description: " + description + "\n" + "Price: $" + price + "\n" + isNew + "\n";
        return out;
    }


    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}