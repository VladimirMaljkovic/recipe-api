package rs.ac.bg.fon.is.ingredient;


import lombok.Getter;

import java.text.DecimalFormat;


/**
 * Represents an ingredient that can be used in a recipe
 */
@Getter
public abstract class Ingredient {

    /**
     * The name of the ingredient
     */
    private String name;
    /**
     * The quantity of the ingredient
     */
    private double quantity;

    /**
     * Constructs a new ingredient with the given name and quantity
     *
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient
     * @throws IllegalArgumentException if the provided name is empty
     * @throws IllegalArgumentException if the quantity is negative
     */
    public Ingredient(String name, double quantity) {
        if(name.equals("")) {
            throw new IllegalArgumentException("Name of an Ingredient can't be empty");
        }
        this.name = name;
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity for {" + name + "} can't be less than 0");
        }
        this.quantity = quantity;
    }

    DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Sets quantity of an ingredient
     *
     * @param quantity quantity to set
     * @throws IllegalArgumentException if the quantity is negative
     */
    public void setQuantity(double quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be less than 0");
        }
        this.quantity = quantity;
    }

    /**
     * Sets name of an ingredient
     *
     * @param name name to set
     * @throws IllegalArgumentException if the provided name is empty
     */
    public void setName(String name) {
        if(name.equals("")) {
            throw new IllegalArgumentException("Name of an Ingredient can't be empty");
        }
        this.name = name;
    }

    /**
     * Returns a string representation of the ingredient including its name and quantity. Also formats the string so decimals are added only if needed.
     *
     * @return a string representation of the ingredient
     */
    @Override
    public String toString() {
        return this.name + " " + df.format(this.quantity);
    }

    /**
     * Uses some quantity of an ingredient and sets the new quantity.
     * @param amount amount of ingredient to use (can't be greater than current quantity)
     */
    public void use(double amount) {
        if (amount > getQuantity()){
            System.out.println("You don't have enough {"+ getName()+ "}");
            return;
        }
        setQuantity(getQuantity() - amount);
    }

    /**
     * Checks if there is enough quantity of ingredient
     *
     * @param amount  Amount of ingredient needed
     * @return <b>true</b> if there is enough of given ingredient, else returns <b>false</b>
     */
    public boolean doIHave(double amount) {
        if (amount > getQuantity()){
            return false;
        }
        return true;
    }
}
