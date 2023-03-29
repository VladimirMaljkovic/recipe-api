package rs.ac.bg.fon.is;

import rs.ac.bg.fon.is.ingredient.Ingredient;
import rs.ac.bg.fon.is.ingredient.LiquidIngredient;
import rs.ac.bg.fon.is.ingredient.SolidIngredient;


public class App 
{
    public static void main( String[] args )
    {
        Ingredient vodka = new LiquidIngredient("vodka", 200);
        Ingredient milk = new LiquidIngredient("milk", 1000);
        Ingredient rice = new SolidIngredient("rice", 500);
        Ingredient ginger = new SolidIngredient("ginger", 2.5);
        System.out.println(vodka);
        System.out.println(milk);
        System.out.println(rice);
        System.out.println(ginger);
        rice.use(260);
        System.out.println(rice);

    }
}
