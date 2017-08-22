package com.test.food;

/**
 * Created by TCIG_PC_54 on 8/22/2017.
 */

public class DrinkModel {
    boolean isHeader;
    int categoryId;
    int drawable;
    String name;
    String description;
    double price;

    public DrinkModel(boolean isHeader, int drawable, String name, String description, double price) {
        this.isHeader = isHeader;
//        this.categoryId = categoryId;
        this.drawable = drawable;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(int categoryId) {
//        this.categoryId = categoryId;
//    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
