import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {SAUCE, "Кетчуп", 10.5F},
                {FILLING, "Котлета", 50F},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getNameSuccess() {
        Assert.assertTrue(ingredient.getName().equals(name));
    }

    @Test
    public void getPriceSuccess() {
        Assert.assertTrue(ingredient.getPrice() == price);
    }

    @Test
    public void getIngredientTypeSuccess() {
        Assert.assertTrue(ingredient.getType().equals(ingredientType));
    }

}
