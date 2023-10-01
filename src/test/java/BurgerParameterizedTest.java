import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

  private List<IngredientType> ingredientType;

  private List<String> name;

  private List<Float> price;

  private List<Ingredient> ingredients = new ArrayList<>();

  private float expectedPrice;

  public BurgerParameterizedTest( List<IngredientType> ingredientType, List<String> name, List<Float> price, float expectedPrice) {
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
    this.expectedPrice = expectedPrice;
  }
  @Parameterized.Parameters
  public static Object[][] getData() {
    return new Object[][] {
            {Arrays.asList(SAUCE, FILLING, FILLING), Arrays.asList("Котлета", "Кетчуп", "Помидор"), Arrays.asList(50F, 5F, 10F), 85F},
            {Arrays.asList(FILLING, FILLING, FILLING, SAUCE), Arrays.asList("Рыба", "Яйцо", "Салат", "Майонез"), Arrays.asList(60F, 10.8F, 11.2F, 6.5F), 108.5F},
            {null, null, null, 20F}

    };
  }

  @Test
  public void getPriceSuccess() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getPrice()).thenReturn(10F);
    if (ingredientType != null && name!= null) {
      for (int i = 0; i<ingredientType.size(); i++) {
        Ingredient ingredient = new Ingredient(ingredientType.get(i), name.get(i), price.get(i));
        burger.addIngredient(ingredient);
      }
    }
    burger.setBuns(bun);
    System.out.println(burger.getPrice());
    Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
  }

  @Test
  public void ReceiptIngredientsAreInCorrectPosition() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getName()).thenReturn("Пшеничная");
    Mockito.when(bun.getPrice()).thenReturn(10F);
    if (ingredientType != null && name!= null) {
      for (int i = 0; i<ingredientType.size(); i++) {
        Ingredient ingredient = new Ingredient(ingredientType.get(i), name.get(i), price.get(i));
        burger.addIngredient(ingredient);
      }
    }
    burger.setBuns(bun);
    String burgerReceipt = burger.getReceipt();
    String [] lines = burgerReceipt.split("\n");
    if (ingredientType != null && name!= null) {
      for (int i = 1; i<ingredientType.size()+1; i++) {
        Assert.assertTrue(lines[i].contains(ingredientType.get(i-1).toString().toLowerCase()));
        Assert.assertTrue(lines[i].contains(name.get(i-1)));
      }
    } else Assert.assertTrue(burgerReceipt.lines().count()==4); //только булочка и цена


  }







  }


