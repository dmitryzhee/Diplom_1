import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.mockito.Mockito.mock;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

  @Mock
  Bun bun;

  @Mock
  List<Ingredient> ingredients;
  @Mock
  Ingredient ingredient;

  @Test
  public void addIngredientSuccess() {
    Burger burger = new Burger(ingredients);
    burger.addIngredient(ingredient);
    Mockito.verify(ingredients).add(ingredient);
  }

  @Test
  public void addIngredientSuccessAlt() {
    Burger burger = new Burger();
    burger.ingredients = ingredients;
    burger.addIngredient(ingredient);
    Mockito.verify(ingredients).add(ingredient);
  }

  @Test
  public void removeIngredientsSuccess() {
    Burger burger = new Burger(ingredients);
    burger.removeIngredient(0);
    Mockito.verify(ingredients).remove(0);
  }

  @Test
  public void moveIngredientSuccess() {
    Burger burger = new Burger(ingredients);
    burger.moveIngredient(2, 1);
    Mockito.verify(ingredients).add(1, ingredients.remove(2));
  }






}
