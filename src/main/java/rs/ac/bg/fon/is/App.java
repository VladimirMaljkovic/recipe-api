package rs.ac.bg.fon.is;

import com.google.gson.JsonObject;
import rs.ac.bg.fon.is.ingredient.CountableIngredient;
import rs.ac.bg.fon.is.ingredient.Ingredient;
import rs.ac.bg.fon.is.ingredient.LiquidIngredient;
import rs.ac.bg.fon.is.ingredient.SolidIngredient;
import rs.ac.bg.fon.is.json_stuff.JsonHelper;
import rs.ac.bg.fon.is.recipe.Recipe;
import rs.ac.bg.fon.is.recipe.RecipeType;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class App 
{
    public static void main( String[] args )
    {

//        Ingredient vodka = new LiquidIngredient("vodka", 200);
//        Ingredient syrup = new LiquidIngredient("Simple syrup", 15);
//        Ingredient amaretto = new LiquidIngredient("Amaretto liqueur", 60);
//        Ingredient lemon_juice = new LiquidIngredient("Lemon juice", 30);
//        Ingredient egg_white = new CountableIngredient("Egg white", 1);
//        Ingredient lemon_wedge = new CountableIngredient("Lemon wedge", 1);
//        Ingredient maraschino_cherry = new CountableIngredient("Caraschino cherry", 1);
//        Ingredient milk = new LiquidIngredient("milk", 1000);
//        Ingredient rice = new SolidIngredient("rice", 500);
//        Ingredient ice = new SolidIngredient("ice", 100);
//        Ingredient ginger = new SolidIngredient("ginger", 2.5);
//
//
//        Recipe amaretto_sour = new Recipe("Amaretto sour", RecipeType.COCKTAIL, "Sweet and sour cocktail", new ArrayList<Ingredient>(Arrays.asList(amaretto, lemon_juice, syrup, egg_white, ice, lemon_wedge, maraschino_cherry)), "Fill a cocktail shaker with ice.\n" +
//                "Add Amaretto liqueur, fresh lemon juice, simple syrup, and egg white to the shaker.\n" +
//                "Shake the mixture vigorously for about 10-15 seconds until well chilled and frothy.\n" +
//                "Strain the mixture into a rocks glass filled with ice.\n" +
//                "Garnish with a lemon wedge and a maraschino cherry.\n" +
//                "Serve and enjoy!\n");
//
//        System.out.println(amaretto_sour);

        File file = new File("src/main/resources/recipes/recipe1.json");
        JsonHelper jsonHelper = new JsonHelper();
        JsonObject recipeJson = jsonHelper.loadJson(file);
        System.out.println(recipeJson);


    }
}
