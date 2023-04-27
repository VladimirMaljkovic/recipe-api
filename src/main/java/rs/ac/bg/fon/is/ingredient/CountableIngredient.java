package rs.ac.bg.fon.is.ingredient;

/**
 * Represents a countable ingredient (eggs, apples...)
 */
public class CountableIngredient extends Ingredient{

    /**
     * Constructs a new countable ingredient with the given name and quantity
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient
     * @see Ingredient#Ingredient(String, double)
     */
    public CountableIngredient(String name, double quantity) {
        super(name, quantity);
    }

    /**
     * Returns a string representation of the countable ingredient including its name and quantity
     *
     * @return a string representation of the countable ingredient
     * @see Ingredient#toString()
     */
    @Override
    public String toString() {
        if (getQuantity() == 1)
        {
            return super.toString() + " pc";
        }
        else
            return super.toString() + " pcs";
    }
}
