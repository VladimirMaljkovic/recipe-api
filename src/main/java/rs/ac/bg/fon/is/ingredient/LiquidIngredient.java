package rs.ac.bg.fon.is.ingredient;

/**
 * Represents a liquid ingredient (milk, wine...)
 */
public class LiquidIngredient extends Ingredient{

    /**
     * Constructs a new liquid ingredient with the given name and quantity
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient
     * @see Ingredient#Ingredient(String, double)
     */
    public LiquidIngredient(String name, double quantity) {
        super(name, quantity);
    }

    /**
     * Returns a string representation of the liquid ingredient including its name and quantity
     *
     * @return a string representation of the liquid ingredient
     * @see Ingredient#toString()
     */
    @Override
    public String toString() {
        return super.toString() + " ml";
    }
}
