import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 10.5F);

    @Test
    public void getNameSuccess() {
        Assert.assertTrue(ingredient.getName().equals("Кетчуп"));
    }

    @Test
    public void getPriceSuccess() {
        Assert.assertTrue(ingredient.getPrice() == 10.5F);
    }

    @Test
    public void getIngredientTypeSuccess() {
        Assert.assertTrue(ingredient.getType().equals(SAUCE));
    }

}
