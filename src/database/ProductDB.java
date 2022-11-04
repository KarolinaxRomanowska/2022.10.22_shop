package database;

import model.Product;

import java.util.Scanner;

public class ProductDB {
    public Product[] products = new Product[3];
    public ProductDB(){
    this.products[0] = new Product (1,
            "Bułka",6,2.5);
    this.products[1] = new Product (2,
            "Baton",2,5.2);
    this.products[2] = new Product (3,
            "Guma do żucia",1,6.0);
    }

    public boolean buyProduct(Integer productCode, Integer ilosc){
        for(Product element : this.products){
            if(element.getProductCode().equals(productCode) && element.getQuantity()>=ilosc && element.getQuantity()>0){
                    element.setQuantity(((element.getQuantity())-ilosc));
                    return true;
            }
        }
        return false;
    }

    public void addProduct(Product product){
        Product[] newProducts = new Product[this.products.length+1];
        for (int i =0; i<this.products.length;i++){
            newProducts[i]=this.products[i];
        }
        newProducts[newProducts.length-1]=product;
        this.products = newProducts;
    }

    public void changeQuantityProduct(int productCode){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ilość");
        int ilosc = scanner.nextInt();
        for (Product element : products){
            if(element.getProductCode().equals(productCode) && ilosc>0){
                element.setQuantity(element.getQuantity() + ilosc);
                break;
            }
        }
    }
    public Product[] getProducts() {
        return products;
    }
}
