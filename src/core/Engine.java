package core;

import database.ProductDB;
import database.UserDB;
import gui.Authenticator;
import gui.GUI;
import model.User;

import java.util.Scanner;

public class Engine {
    public static void start() {
        final ProductDB productDB = new ProductDB();
        final UserDB userDB = new UserDB();
        boolean isWorking = Authenticator.authenticate(userDB);
        final Scanner scanner = new Scanner(System.in);

        while(isWorking) {
            GUI.showMenu();
            switch(scanner.nextLine()) {
                case "1":
                    GUI.showProductsList(productDB.getProducts());
                    break;
                case "2":
                    System.out.println("Product Code:");
                    int code = scanner.nextInt();
                    System.out.println("Ilość: ");
                    int ilosc = scanner.nextInt();
                    if(productDB.buyProduct(code,ilosc)) {
                        System.out.println("You have buy this product !!!");
                        break;
                    } else {
                        System.out.println("Buy error !!");
                        break;
                    }
                   // break;
                case "4":
                    scanner.close();
                    isWorking = false;
                    break;
                case "3":
                    if(Authenticator.loggedUser.getRole() == User.Role.ADMIN) {
                        GUI.addProduct(productDB);
                        break;
                    }
                    else{
                        System.out.println("Brak dostępu");
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }

    }
}
