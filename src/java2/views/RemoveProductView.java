package java2.views;

import java2.services.RemoveProductService;

import java.util.Scanner;

public class RemoveProductView {

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    public void execute() {
        System.out.println();
        System.out.println("Remove product from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        final String title = sc.nextLine();

        boolean isRemoved = removeProductService.remove(title);
        
        if (isRemoved) {
            System.out.println("Product with title " + title + " was found and will be removed from list!");
        } else {
            System.out.println("Product with title " + title + " not found and not be removed from list!");
        }

        System.out.println("Remove product from list execution end!");
        System.out.println();
    }

}
