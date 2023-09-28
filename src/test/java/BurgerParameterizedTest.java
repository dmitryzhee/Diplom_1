import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
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
            {Arrays.asList(FILLING, SAUCE, FILLING), Arrays.asList("Курица", "Майонез", "Салат"), Arrays.asList(40F,6.5F, 11.2F), 77.7F},
            {Arrays.asList(FILLING, FILLING, FILLING), Arrays.asList("Рыба", "Яйцо", "Салат"), Arrays.asList(60F,10.8F, 11.2F), 102F},

    };
  }

//    @Test
//    public void addIngredientSuccess() {
//      Burger burger = new Burger(ingredients);
//      Ingredient ingredient = new Ingredient(ingredientType, name, price);
//      burger.addIngredient(ingredient);
//      Assert.assertTrue(ingredients.get(0)==ingredient);
//    }

  @Test
  public void getPriceSuccess() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getPrice()).thenReturn(10F);
    for (int i = 0; i<ingredientType.size(); i++) {
      Ingredient ingredient = new Ingredient(ingredientType.get(i), name.get(i), price.get(i));
      burger.addIngredient(ingredient);
    }
    burger.setBuns(bun);
    System.out.println(burger.getPrice());
    Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
  }

  @Test
  public void getReceiptSuccess() {
    Burger burger = new Burger();
    Bun bun = mock(Bun.class);
    Mockito.when(bun.getName()).thenReturn("Пшеничная");
    for (int i = 0; i<ingredientType.size(); i++) {
      Ingredient ingredient = new Ingredient(ingredientType.get(i), name.get(i), price.get(i));
      burger.addIngredient(ingredient);
    }
    burger.setBuns(bun);
    burger.getReceipt();
    System.out.println(burger.getReceipt());
  }





  }


