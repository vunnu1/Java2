package javaguru;


import javaguru.services.AddProductService;
import javaguru.services.GetShoppingListService;
import javaguru.services.RemoveProductService;

import java.database.ProductRepository;
import java.database.jdbc.ProductRepositoryImpl;
import java.util.Scanner;
import java.views.PrintShoppingListView;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit

        ProductRepository database = new ProductRepositoryImpl();

        AddProductService addProductService = new AddProductService(database);
        RemoveProductService removeProductService = new RemoveProductService(database);
        GetShoppingListService getShoppingListService = new GetShoppingListService(database);

        AddProductView addProductView = new AddProductView(addProductService);
        RemoveProductView removeProductView = new RemoveProductView(removeProductService);
        PrintShoppingListView printShoppingListView = new PrintShoppingListView(getShoppingListService);

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    addProductView.execute();
                    break;
                }
                case 2: {
                    removeProductView.execute();
                    break;
                }
                case 3: {
                    printShoppingListView.execute();
                    break;
                }
            }
        }
    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);