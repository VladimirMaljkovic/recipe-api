package rs.ac.bg.fon.is.ingredient;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CountableIngredientTest {

    @Test
    public void testCountableToStringSingle() {
        Ingredient ingredient = new CountableIngredient("egg", 1);
        assertEquals("egg 1 pc", ingredient.toString());
    }

    @Test
    public void testCountableToStringMore() {
        Ingredient ingredient = new CountableIngredient("egg", 3);
        assertEquals("egg 3 pcs", ingredient.toString());
    }

    @Test
    public void testCountableToStringRounding() {
        Ingredient ingredient = new CountableIngredient("egg", 0.3333);
        assertEquals("egg 0.33 pcs", ingredient.toString());
    }
}
