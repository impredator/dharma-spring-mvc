package com.dharma.springmvc;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import com.dharma.springmvc.model.Product;
import org.springframework.web.client.RestTemplate;

public class DharmaMallRestTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllProducts(){
        System.out.println("Testing getProducts API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> productsMap = restTemplate.getForObject(REST_SERVICE_URI+"/product/", List.class);

        if(productsMap!=null){
            for(LinkedHashMap<String, Object> map : productsMap){
                System.out.println("Product : id="+map.get("id")+", Name="+map.get("name")+", Price="+map.get("price")+", Count="+map.get("count"));;
            }
        }else{
            System.out.println("No product exist----------");
        }
    }

    /* GET */
    private static void getProduct(){
        System.out.println("Testing getProduct API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(REST_SERVICE_URI+"/product/1", Product.class);
        System.out.println(product);
    }

    /* POST */
    private static void createProduct() {
        System.out.println("Testing create Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product(0,"Nokia",999.0,100000);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/product/", product, Product.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateProduct() {
        System.out.println("Testing update Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        Product product  = new Product(1,"Nokia",1699.0, 70000);
        restTemplate.put(REST_SERVICE_URI+"/product/1", product);
        System.out.println(product);
    }

    /* DELETE */
    private static void deleteProduct() {
        System.out.println("Testing delete Product API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/product/3");
    }


    /* DELETE */
    private static void deleteAllProducts() {
        System.out.println("Testing all delete Products API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/product/");
    }

    public static void main(String args[]){
        listAllProducts();
        getProduct();
        createProduct();
        listAllProducts();
        updateProduct();
        listAllProducts();
        deleteProduct();
        listAllProducts();
        deleteAllProducts();
        listAllProducts();
    }
}