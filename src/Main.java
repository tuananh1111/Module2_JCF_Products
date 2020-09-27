import model.Product;
import service.PriceComparator;
import service.ProductManager;

import java.util.*;

public class Main {
    static void display(List products){
        Iterator<Product> iterator=products.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        ProductManager productManager= new ProductManager();
        List<Product> productList;
        productList=productManager.showAll();
        display(productList);

        // add product
        System.out.println("Add Product:");
        productList.add(new Product(6,"mouse",150000));
        display(productList);

        //update product
        System.out.println("update product");
        productManager.update(1L,new Product(1, "boost", 555555));
        productList=productManager.showAll();
        display(productList);

        System.out.println("Delete product");
        productManager.delete(1L);
        productList=productManager.showAll();
        display(productList);

        System.out.println("Sap xep theo gia:");
        PriceComparator priceComparator=new PriceComparator();
        Collections.sort(productList,Collections.reverseOrder(priceComparator));
        display(productList);

        System.out.println("Find by Name");
        productList=productManager.findProByName("Oreo");
        display(productList);

    }
}
