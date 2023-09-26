import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  Burger burger = new Burger();
  @Mock
  Bun bun;

  @Mock
  List<Ingredient> ingredients;

  Ingredient ingredient = new Ingredient(SAUCE, "Кетчуп", 10);

  @Test
  public void addIngredientSuccess() {
    burger.addIngredient(ingredient);
    Mockito.verify(ingredients).add(ingredient);
  }

  @Test
  public void setBunsSuccess() {
    burger.setBuns(bun);
    Mockito.verify(burger).setBuns(bun);
  }



}
