package org.launchcode.java.restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.launchcode.java.restaurant.MenuItem.categories;

/**
 * Created by Jen Kocher on 4/23/2017.
 */


public class Restaurant {

    public static void main(String[] args){

        int goOn = 1;
        int choice;

        Scanner scanner = new Scanner(System.in);

        //create menu
        Menu menu = new Menu();

        while (goOn == 1) {
            System.out.println("\n\nRestaurant Administration\n");
            System.out.println("1 - Display menu.");
            System.out.println("2 - Add item to menu.");
            System.out.println("3 - Remove item from menu.");
            System.out.println("4 - Display menu items.\n");
            System.out.println("Enter 0 to quit.\n");

            choice = scanner.nextInt();

            if (choice != 0) {
                if (choice == 1){
                    //Display menu
                    System.out.println("DISPLAY MENU\n");
                    System.out.println("Menu\nLast Updated: " + menu.getDateChanged() + "\n");
                    if (menu.getMenuItems().size() == 0) {
                        System.out.println("Menu is empty.\n");
                    } else {
                        for (int i=0;i<menu.getMenuItems().size();i++){
                            System.out.println(menu.getMenuItems().get(i).toString()
                            );
                        }
                    }

                } else if (choice == 2){
                    // Add item to menu
                    System.out.println("ADD ITEM TO MENU\n");

                    System.out.println("Select the item's category: ");
                    for (int i=1;i<categories.size()+1;i++){
                        System.out.println(i + "- " + categories.get(i-1));
                    }
                    System.out.println("");
                    int nbr = scanner.nextInt();
                    String aCategory = categories.get(nbr-1);

                    System.out.print("Enter the item's description: \n");
                    String aDescription = scanner.next();

                    System.out.print("Enter the item's price: ");
                    Double aPrice = scanner.nextDouble();

                    MenuItem aMenuItem = new MenuItem(aCategory, aDescription, aPrice);
                    menu.addMenuItem(aMenuItem);

                } else if (choice == 3) {
                    //Remove item from menu
                    System.out.println("REMOVE MENU ITEM\n");
                    if (menu.getMenuItems().size() == 0) {
                        System.out.println("Menu is empty.\n");
                    } else {
                        String removeItem;

                        List<MenuItem> duplicate = new ArrayList<MenuItem>();
                        List<MenuItem> found = new ArrayList<MenuItem>();

                        duplicate = menu.getMenuItems();

                        System.out.print("Enter the description of the item to be removed: \n");
                        removeItem = scanner.next();

                        for (int i=0; i<duplicate.size(); i++){
                            if (duplicate.get(i).getDescription().equals(removeItem)){
                                found.add(duplicate.get(i));
                            }
                        }

                        menu.getMenuItems().removeAll(found);
                    }
                } else {
                    //Display menu items
                    System.out.println("DISPLAY MENU ITEMS\n");
                    if (menu.getMenuItems().size() == 0) {
                        System.out.println("Menu is empty.\n");
                    } else {
                            for (int i=0;i<menu.getMenuItems().size();i++){
                                System.out.println(menu.getMenuItems().get(i).toString());
                            }
                    }


                }
            } else goOn = 0;
        }
    }
}
