package rs.ac.bg.fon.is.ingredient;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolidIngredientTest {

    @Test
    public void testSolidToString() {
        Ingredient ingredient = new SolidIngredient("sugar", 500);
        assertEquals("sugar 500 g", ingredient.toString());
    }

    @Test
    public void testLSolidToStringRounding() {
        Ingredient ingredient = new SolidIngredient("baking powder", 2.66667);
        assertEquals("baking powder 2.67 g", ingredient.toString());
    }
}
