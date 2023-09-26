import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 10);

    @Test
    public void getNameSuccess() {
        Assert.assertTrue(ingredient.getName().equals("Кетчуп"));
    }

    @Test
    public void getPriceSuccess() {
        Assert.assertTrue(ingredient.getPrice() == 10);
    }

    @Test
    public void getIngredientTypeSuccess() {
        Assert.assertTrue(ingredient.getType().equals(SAUCE));
    }

}
