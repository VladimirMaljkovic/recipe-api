package rs.ac.bg.fon.is.recipe;

import lombok.Getter;
import lombok.Setter;
import rs.ac.bg.fon.is.ingredient.Ingredient;

import java.util.List;

/**
 * Represents a recipe.
 */
@Getter
@Setter
public class Recipe {
    /**
     * The name of the recipe
     */
    private String name;
    /**
     * The type of the recipe (cocktail, soup...)
     */
    private String type;
    /**
     * The short description of the recipe
     */
    private String short_desc;
    /**
     * The list of ingredients a recipe has
     */
    private List<Ingredient> ingredients;
    /**
     * The detailed description of the recipe
     */
    private String detailed_desc;

    /**
     * Constructs a new recipe object with the following parameters:
     * @param name the name of the recipe
     * @param type the type of the recipe (enum)
     * @param short_desc short description of the recipe
     * @param ingredients list of ingredients needed for the rcipe
     * @param detailed_desc detailed description of the recipe
     */

    public Recipe(String name, String type, String short_desc, List<Ingredient> ingredients, String detailed_desc) {
        this.name = name;
        this.type = type;
        this.short_desc = short_desc;
        this.ingredients = ingredients;
        this.detailed_desc = detailed_desc;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", short_desc='" + short_desc + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
