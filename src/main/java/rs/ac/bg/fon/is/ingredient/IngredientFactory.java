package rs.ac.bg.fon.is.ingredient;

public class IngredientFactory {

    public static Ingredient createIngredient(String name, double quantity, String type) {
        return switch (type.toLowerCase()) {
            case "countable" -> new CountableIngredient(name, quantity);
            case "liquid" -> new LiquidIngredient(name, quantity);
            case "solid" -> new SolidIngredient(name, quantity);
            default -> throw new IllegalArgumentException("Invalid ingredient type: " + type);
        };
    }
}
