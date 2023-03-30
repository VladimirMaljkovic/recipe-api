package rs.ac.bg.fon.is.ingredient;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LiquidIngredientTest {

    @Test
    public void testLiquidToString() {
        Ingredient ingredient = new LiquidIngredient("milk", 300);
        assertEquals("milk 300 ml", ingredient.toString());
    }

    @Test
    public void testLiquidToStringRounding() {
        Ingredient ingredient = new LiquidIngredient("vanilla extract", 1.3333);
        assertEquals("vanilla extract 1.33 ml", ingredient.toString());
    }
}
