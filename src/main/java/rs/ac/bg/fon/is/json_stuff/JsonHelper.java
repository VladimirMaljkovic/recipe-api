package rs.ac.bg.fon.is.json_stuff;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.is.ingredient.*;
import rs.ac.bg.fon.is.recipe.Recipe;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class used to convert objects from and to JSON format
 */
public class JsonHelper {

    /**
     * Gson object used within the class for transformations
     */
    private Gson gson;

    /**
     * Loads a jsonObject from a file
     * @param file - file object that has the json we want to load
     * @return a JsonObject file
     */
    public JsonObject loadJson(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            gson = new Gson();
            return  gson.fromJson(fileReader, JsonObject.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a Recipe object from json object
     * @param recipeJson - recipe json object
     * @return Recipe object
     */
    public Recipe loadRecipeFromJson(JsonObject recipeJson){
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        String recipeName;
        String recipeType;
        String shortDesc;
        String detailedDesc;

        recipeName = recipeJson.get("name").getAsString();
        recipeType = recipeJson.get("type").getAsString();
        shortDesc = recipeJson.get("short_desc").getAsString();
        detailedDesc = recipeJson.get("detailed_desc").getAsString();
        JsonArray ingredientsJson = recipeJson.getAsJsonArray("ingredients");

        for (JsonElement e: ingredientsJson) {
            JsonObject jsonObject = e.getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            String type = jsonObject.get("type").getAsString();
            Double quantity = jsonObject.get("quantity").getAsDouble();

            ingredients.add(IngredientFactory.createIngredient(name, quantity, type));
        }


        return new Recipe(recipeName, recipeType, shortDesc, ingredients, detailedDesc);
    }

    public void saveJson(Recipe recipe) throws Exception{
        JsonObject recipeJson = new JsonObject();
        recipeJson.addProperty("name", recipe.getName());
        recipeJson.addProperty("type", recipe.getType());
        recipeJson.addProperty("short_desc", recipe.getShort_desc());
        recipeJson.addProperty("detailed_desc", recipe.getDetailed_desc());

        JsonArray ingredientsJson = new JsonArray();

        for(Ingredient ingredient: recipe.getIngredients()) {
            JsonObject ingredientJson = new JsonObject();
            ingredientJson.addProperty("name", ingredient.getName());
            ingredientJson.addProperty("quantity", ingredient.getQuantity());
            if(ingredient.getClass() == CountableIngredient.class) {
                ingredientJson.addProperty("type", "countable");
            }
            else if(ingredient.getClass() == LiquidIngredient.class) {
                ingredientJson.addProperty("type", "liquid");
            }
            else if(ingredient.getClass() == SolidIngredient.class) {
                ingredientJson.addProperty("type", "solid");
            }
            else
                throw new Exception("Illegal ingredient type");
            ingredientsJson.add(ingredientJson);
        }
        recipeJson.add("ingredients", ingredientsJson);

        System.out.println(recipeJson);

    }

}
