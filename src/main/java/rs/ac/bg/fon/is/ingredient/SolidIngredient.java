package rs.ac.bg.fon.is.ingredient;

/**
 * Represents a solid ingredient (flour, rice...)
 */
public class SolidIngredient extends Ingredient{

    /**
     * Constructs a new solid ingredient with the given name and quantity
     * @param name the name of the ingredient
     * @param quantity the quantity of the ingredient
     * @see Ingredient#Ingredient(String, double)
     */
    public SolidIngredient(String name, double quantity) {
        super(name, quantity);
    }

    /**
     * Returns a string representation of the solid ingredient including its name and quantity
     *
     * @return a string representation of the solid ingredient
     * @see Ingredient#toString()
     */
    @Override
    public String toString() {
        return super.toString() + " g";
    }
}
