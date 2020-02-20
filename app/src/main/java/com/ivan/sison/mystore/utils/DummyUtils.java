package com.ivan.sison.mystore.utils;

import com.ivan.sison.mystore.data.entities.Product;
import com.ivan.sison.mystore.data.entities.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class DummyUtils {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(0, "MSI Infinite S 9SH-066PH Gaming Desktop", "KM", "59000"));
        products.add(new Product(0, "MSI Infinite S 9SI-065PH Gaming Desktop", "KM", "79950"));
        products.add(new Product(0, "MSI Trident A 9SC-473PH Gaming Desktop", "KM", "94500"));
        products.add(new Product(0, "Acer Aspire XC-730 Intel J3355 CeleronAcer Aspire XC-730 Intel J3355 Celeron", "KM", "12000"));
        products.add(new Product(0, "Amd Ryzen 3 2200G Vega 8 Graphics 4", "KM", "14260"));
        products.add(new Product(0, "AMD Ryzen 5 2400G Vega 11 Graphics 8GB", "KM", "20800"));
        products.add(new Product(0, "Intel Pentium G5400 3.70 GHz", "KM", "13600"));
        products.add(new Product(0, "Asus (K31AN-BING-PH001) PQC J2900", "KM", "12890"));
        products.add(new Product(0, "HP Pavilion 24-B217D (Touch) Desktop", "KM", "45000"));
        products.add(new Product(0, "Intel Core i3-8100 3.60GHz", "KM", "16666"));
        return products;
    }

    public static List<ProductCategory> getProductCategories() {
        List<ProductCategory> categories = new ArrayList<>();

        categories.add(new ProductCategory(0, "Computers", ""));
        categories.add(new ProductCategory(0, "Peripherals", ""));
        categories.add(new ProductCategory(0, "Accessories", ""));
        categories.add(new ProductCategory(0, "Networking", ""));

        return categories;
    }
}
