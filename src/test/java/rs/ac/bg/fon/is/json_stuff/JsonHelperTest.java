package rs.ac.bg.fon.is.json_stuff;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import rs.ac.bg.fon.is.recipe.Recipe;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonHelperTest {

    @Test
    public void testLoadJson() {
        JsonObject jsonObject = null;
        try (FileReader fileReader = new FileReader("src/test/resources/recipes/amaretto_sour.json")) {
            Gson gson = new Gson();
            jsonObject = gson.fromJson(fileReader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;
        assertEquals(jsonObject.get("name").getAsString(), "Amaretto sour");
        assertEquals(jsonObject.get("type").getAsString(), "COCKTAIL");
        assertEquals(jsonObject.get("short_desc").getAsString(), "Sweet and sour cocktail");
        assertEquals(jsonObject.get("ingredients").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString(), "Amaretto liqueur");
        assertEquals(jsonObject.get("ingredients").getAsJsonArray().get(0).getAsJsonObject().get("type").getAsString(), "liquid");

    }

    @Test
    public void testLoadRecipeFromJson() {
        JsonObject jsonObject = null;
        try (FileReader fileReader = new FileReader("src/test/resources/recipes/amaretto_sour.json")) {
            Gson gson = new Gson();
            jsonObject = gson.fromJson(fileReader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert jsonObject != null;

        JsonHelper jsonHelper = new JsonHelper();
        Recipe recipe = jsonHelper.loadRecipeFromJson(jsonObject);

        assertEquals(recipe.getName(), "Amaretto sour");
        assertEquals(recipe.getType(), "COCKTAIL");
        assertEquals(recipe.getIngredients().get(1).getName(), "Lemon juice");
        assertEquals(recipe.getIngredients().get(1).getQuantity(), 30, 0.001); //delta is required since double, double is deprecated
    }
}
