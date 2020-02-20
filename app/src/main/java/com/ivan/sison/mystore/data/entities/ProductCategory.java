package com.ivan.sison.mystore.data.entities;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_categories")
public class ProductCategory {

    @PrimaryKey
    private int id;

    private String name;
    private String code;

    public ProductCategory(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
