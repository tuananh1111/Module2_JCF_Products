package service;
import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManager implements IManager<Product> {
    static List<Product> products= new ArrayList<>();
    static {

        products.add(new Product(1,"Shampoo",86000));
        products.add(new Product(2,"Oreo",20000));
        products.add(new Product(3,"Shoes",1586000));
        products.add(new Product(4,"Bag",586000));
        products.add(new Product(5,"Whey",1100000));
    }

    @Override
    public void add(Product object) {
        if (!checkID(object.getId())){
            products.add(object);
        }
    }

    @Override
    public void update(long id, Product newObject) {
        if (checkID(id)){
            products.set((int) id-1,newObject);
        }else products.add(newObject);

    }

    @Override
    public void delete(long id) {
        for (int i=0; i<products.size();i++){
            if (id == products.get(i).getId()){
                products.remove(i);
            }
        }

    }

    @Override
    public List<Product> showAll() {
        List<Product> productList= new ArrayList<>();
        Iterator<Product> iterator= products.iterator();
        while (iterator.hasNext()){
                productList.add(iterator.next());
        }
        return productList;
    }

    @Override
    public List<Product> findProByName(String name) {
        List<Product> list= new ArrayList<>();
        for (int i=0; i<products.size();i++){
            if (name== products.get(i).getName()){
                list.add(products.get(i));
            }
        }return list;
    }

    @Override
    public Product findById(long id) {
        Product idProduct=null;
        for (int i=0;i<products.size();i++){
            if (id==products.get(i).getId()){
                idProduct=products.get(i);
            }
        }return idProduct;
    }

    public boolean checkID(long id){
        for (Product product: products){
             if(product.getId()==id){
                 return true;
             }
        }return false;
    }

}
