package rs.ac.bg.fon.is.ingredient;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class IngredientFactoryTest {

    @Test
    public void testCreatingCountableIngredients() {
        Ingredient ingredient = IngredientFactory.createIngredient("egg", 2, "countable");
        assertEquals(ingredient.getClass(), CountableIngredient.class);
    }

    @Test
    public void testCreatingLiquidIngredients() {
        Ingredient ingredient = IngredientFactory.createIngredient("coconut oil", 250, "LIQuid");
        assertEquals(ingredient.getClass(), LiquidIngredient.class);
    }

    @Test
    public void testCreatingSolidIngredients() {
        Ingredient ingredient = IngredientFactory.createIngredient("coconut flour", 330, "solId");
        assertEquals(ingredient.getClass(), SolidIngredient.class);
    }
}
