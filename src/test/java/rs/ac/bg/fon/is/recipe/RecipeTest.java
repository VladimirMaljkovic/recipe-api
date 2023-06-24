package rs.ac.bg.fon.is.recipe;

import org.junit.Test;
import rs.ac.bg.fon.is.ingredient.CountableIngredient;
import rs.ac.bg.fon.is.ingredient.Ingredient;
import rs.ac.bg.fon.is.ingredient.LiquidIngredient;
import rs.ac.bg.fon.is.ingredient.SolidIngredient;

import javax.naming.spi.NamingManager;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipeTest {

    Ingredient syrup = new LiquidIngredient("Simple syrup", 15);
    Ingredient amaretto = new LiquidIngredient("Amaretto liqueur", 60);
    Ingredient lemon_juice = new LiquidIngredient("Lemon juice", 30);
    Ingredient egg_white = new CountableIngredient("Egg white", 1);
    Ingredient lemon_wedge = new CountableIngredient("Lemon wedge", 1);
    Ingredient maraschino_cherry = new CountableIngredient("Maraschino cherry", 1);
    Ingredient ice = new SolidIngredient("ice", 100);
    Recipe amaretto_sour = new Recipe("Amaretto sour", "COCKTAIL", "Sweet and sour cocktail", new ArrayList<Ingredient>(Arrays.asList(amaretto, lemon_juice, syrup, egg_white, ice, lemon_wedge, maraschino_cherry)), "Fill a cocktail shaker with ice.\n" +
            "Add Amaretto liqueur, fresh lemon juice, simple syrup, and egg white to the shaker.\n" +
            "Shake the mixture vigorously for about 10-15 seconds until well chilled and frothy.\n" +
            "Strain the mixture into a rocks glass filled with ice.\n" +
            "Garnish with a lemon wedge and a maraschino cherry.\n" +
            "Serve and enjoy!\n");

    @Test
    public void testRecipeName1() {
        assertEquals("Amaretto sour", amaretto_sour.getName());
    }

    @Test
    public void testRecipeName2() {
        amaretto_sour.setName("new name");
        assertEquals("new name", amaretto_sour.getName());
    }

    @Test
    public void testRecipeType1() {
        assertEquals("COCKTAIL", amaretto_sour.getType());
    }

    @Test
    public void testRecipeType2() {
        amaretto_sour.setType("DISH");
        assertEquals("DISH", amaretto_sour.getType());
    }

    @Test
    public void testIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(syrup);
        ingredients.add(amaretto);
        ingredients.add(ice);
        ingredients.add(lemon_juice);
        ingredients.add(lemon_wedge);
        ingredients.add(egg_white);
        ingredients.add(maraschino_cherry);
        boolean flag = true;
        for(Ingredient i: ingredients) {
            if (!amaretto_sour.getIngredients().contains(i))
                flag = false;
        }
        assertTrue(flag);
    }
}
