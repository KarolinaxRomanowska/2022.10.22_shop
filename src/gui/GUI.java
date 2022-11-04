package gui;

import database.ProductDB;
import database.UserDB;
import model.Product;
import model.User;

import java.util.Scanner;
import java.util.SortedMap;

public class GUI {
    public static void showMenu() {
        System.out.println("1. Wyświetl listę produktów");
        System.out.println("2. Kup produkt");
        System.out.println("3. Dodaj produkt");
        System.out.println("4. Exit");
    }

    public static void showProductsList(Product[] products){
        for (Product element : products){
            if(element.getQuantity()>0){
            System.out.println(element.getProductCode()+" "+ element.getName()+" "+ element.getQuantity()+" "+ element.getPrice());
            }
        }
    }
    public static User readLoginAndPassword() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        return new User (login,password);
    }

    public static void addProduct(ProductDB productDB){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Kod produktu:");
        int code = scanner.nextInt();

        if (code > productDB.products.length){
            Product newproduct = new Product();
            newproduct.setProductCode(code);
            System.out.println("Nazwa: ");
            String name = scanner.nextLine();
            newproduct.setName(name);
            System.out.println("Cena: ");
            newproduct.setPrice(Double.parseDouble(scanner.nextLine()));
            System.out.println("Ilość: ");
            newproduct.setQuantity(scanner.nextInt());
            productDB.addProduct(newproduct);
            System.out.println("Product added!!");
        }
        else {
            productDB.changeQuantityProduct(code);
                }
            }
        }
