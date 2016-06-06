package com.example.tony.ingredientTree;

/**
 * Created by Tony on 6/6/2016.
 */
public abstract class Ingredient {
    String ingredName;
//    Ingredient ingredType;
    int ingredQuantity;

    public String getIngredName() {
        return ingredName;
    }

    public int getIngredQuantity() {
        return ingredQuantity;
    }

    public void setIngredName(String ingredName) {
        this.ingredName = ingredName;
    }

    public void setIngredQuantity(int ingredQuantity) {
        this.ingredQuantity = ingredQuantity;
    }
}
