package rs.ac.bg.fon.is.json_stuff;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import rs.ac.bg.fon.is.ingredient.Ingredient;
import rs.ac.bg.fon.is.recipe.Recipe;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonHelper {

    private Gson gson;

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

    public Recipe loadRecipeFromJson(JsonObject recipeJson){
        ArrayList<Ingredient> ingredients = new ArrayList<>();


        return null;
    }

}
