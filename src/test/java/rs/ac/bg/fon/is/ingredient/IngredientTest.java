package rs.ac.bg.fon.is.ingredient;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName1() {
        Ingredient ingredient = new SolidIngredient("", 10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeQuantity() {
        Ingredient ingredient = new LiquidIngredient("milk", -1.0);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new CountableIngredient("Egg", 3);
        assertEquals("Egg", ingredient.getName());
    }

    @Test
    public void testGetQuantity() {
        Ingredient ingredient = new SolidIngredient("Salt", 250);
        assertEquals(250, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testSetQuantity() {
        Ingredient ingredient = new SolidIngredient("Butter", 100);
        ingredient.setQuantity(200);
        assertEquals(200, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testUseEnough() {
        Ingredient ingredient = new SolidIngredient("Flour", 1000);
        ingredient.use(600);
        assertEquals(400, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testUseNotEnough() {
        Ingredient ingredient = new LiquidIngredient("Oil", 50);
        ingredient.use(120);
        assertEquals(50, ingredient.getQuantity(), 0.0);
    }

    @Test
    public void testDoIHaveEnough() {
        Ingredient ingredient = new SolidIngredient("flour", 500);
        assertTrue(ingredient.doIHave(450));
    }

    @Test
    public void testDoIHaveNotEnough() {
        Ingredient ingredient = new SolidIngredient("flour", 500);
        assertFalse(ingredient.doIHave(502));
    }

    @Test
    public void testDoIHaveBarely() {
        Ingredient ingredient = new SolidIngredient("flour", 500);
        assertTrue(ingredient.doIHave(500));
    }
}
