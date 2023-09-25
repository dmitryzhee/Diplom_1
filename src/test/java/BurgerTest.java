import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
  @Mock
  Burger burger;
  @Mock
  Bun bun;

  @Test
  public void setBunsSuccess() {
    burger.setBuns(bun);
    Mockito.verify(burger).setBuns(bun);
  }


}
