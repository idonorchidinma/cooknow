package com.example.tony.ingredientTree;

/**
 * Created by Tony on 6/6/2016.
 */
public class VegeType extends Ingredient {
    String ingredName;
    int ingredQuantity;

    public VegeType(String ingredName, int ingredQuantity) {
        this.ingredName = ingredName;
        this.ingredQuantity = ingredQuantity;
    }

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
