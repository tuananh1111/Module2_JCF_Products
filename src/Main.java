import model.Product;
import service.PriceComparator;
import service.ProductManager;

import java.util.*;

public class Main {
    static void display(List<Product> products){
        Iterator<Product> iterator=products.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        ProductManager productManager= new ProductManager();
        List<Product> productList=new ArrayList<>();
        productList= productManager.showAll();
        display(productList);

        System.out.println("=====Add product=====");
        Product newPro= new Product(7,"IphoneX",11000000);
        productList.add(newPro);
        display(productList);

        System.out.println("====Delete====");
        productManager.delete(4L);
        productList=productManager.showAll();
        display(productList);

        System.out.println("====Update====");
        Scanner input= new Scanner(System.in);
        System.out.println("Input Id: ");
        long id= input.nextLong();
        System.out.println("Input Name: ");
        input.nextLine();
        String name= input.nextLine();
        System.out.println("Input Price:");
        Double price= input.nextDouble();
        Product newProduct= new Product(id,name,price);
        productManager.update(id,newProduct);
        productList= productManager.showAll();
        display(productList);


        List<Product> list= new ArrayList<>();
        System.out.println("====Find Product by ID=====");
        System.out.println("Input name:");
        String namePro= input.next();
        System.out.println();
        list=productManager.findProByName(namePro);
        display(list);

        System.out.println("=====Sắp xếp theo giá ====");
        PriceComparator priceComparator= new PriceComparator();
        List<Product> list1;
        list1= productManager.showAll();
        Collections.sort(list1,Collections.reverseOrder(priceComparator));
        display(list1);
    }
}
