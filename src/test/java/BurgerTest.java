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


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  @Mock
  List<Ingredient> ingredients;
  @Mock
  Ingredient ingredient;


  @Test
  public void addIngredientSuccess() {
    Burger burger = new Burger();
    burger.ingredients = ingredients;
    burger.addIngredient(ingredient);
    Mockito.verify(ingredients).add(ingredient);
  }

  @Test
  public void removeIngredientsSuccess() {
    Burger burger = new Burger();
    burger.ingredients = ingredients;
    burger.removeIngredient(0);
    Mockito.verify(ingredients).remove(0);
  }

  @Test
  public void moveIngredientSuccess() {
    Burger burger = new Burger();
    burger.ingredients = ingredients;
    burger.moveIngredient(2, 1);
    Mockito.verify(ingredients).add(1, ingredients.remove(2));
  }

  @Test
  public void burgerWithoutIngredientsGetReceiptSuccess() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getName()).thenReturn("Пшеничная");
    Mockito.when(bun.getPrice()).thenReturn(10F);
    burger.setBuns(bun);
    String burgerReceipt = burger.getReceipt();
    String[] lines = burgerReceipt.split("\n");
    Assert.assertEquals(burgerReceipt.lines().count(), 4); //только булочка и цена
    Assert.assertTrue(lines[0].contains(String.format("(==== %s ====)", bun.getName())));
    Assert.assertTrue(lines[1].contains(String.format("(==== %s ====)", bun.getName())));
    Assert.assertTrue(lines[2].isBlank());
    Assert.assertTrue(lines[3].contains("Price"));
  }

  @Test
  public void burgerWithoutIngredientsGetPriceSuccess() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getPrice()).thenReturn(15F);
    burger.setBuns(bun);
    Assert.assertEquals(burger.getPrice(),  bun.getPrice()*2, 0);
  }






}
