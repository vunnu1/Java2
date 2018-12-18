package java2;

import java2.db.InMemoryDatabase;
import java2.services.AddProductService;
import java2.services.GetShoppingListService;
import java2.services.RemoveProductService;
import java2.views.AddProductView;
import java2.views.PrintShoppingListView;
import java2.views.RemoveProductView;

import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit
        
        Database database = new InMemoryDatabase();

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
        return Integer.parseInt(sc.nextLine());
    }

}