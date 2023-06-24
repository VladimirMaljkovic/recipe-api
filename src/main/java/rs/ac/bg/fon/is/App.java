package rs.ac.bg.fon.is;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.is.json_stuff.JsonHelper;
import rs.ac.bg.fon.is.recipe.Recipe;

import java.io.File;


public class App
{
    public static void main( String[] args ) throws Exception {

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
//        Recipe amaretto_sour = new Recipe("Amaretto sour", "COCKTAIL", "Sweet and sour cocktail", new ArrayList<Ingredient>(Arrays.asList(amaretto, lemon_juice, syrup, egg_white, ice, lemon_wedge, maraschino_cherry)), "Fill a cocktail shaker with ice.\n" +
//                "Add Amaretto liqueur, fresh lemon juice, simple syrup, and egg white to the shaker.\n" +
//                "Shake the mixture vigorously for about 10-15 seconds until well chilled and frothy.\n" +
//                "Strain the mixture into a rocks glass filled with ice.\n" +
//                "Garnish with a lemon wedge and a maraschino cherry.\n" +
//                "Serve and enjoy!\n");
//
//        System.out.println(amaretto_sour);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("src/main/resources/recipes/amaretto_sour.json");
        JsonHelper jsonHelper = new JsonHelper();
        JsonObject recipeJson = jsonHelper.loadJson(file);

        Recipe amarettoSour = jsonHelper.loadRecipeFromJson(recipeJson);

        jsonHelper.saveJson(amarettoSour);


    }
}
