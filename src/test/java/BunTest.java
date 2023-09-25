import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
Bun bun;

  @Test
  public void getNameSuccess() {
    bun = new Bun("Ржаная", 0);
    Assert.assertEquals(bun.getName(), "Ржаная");
  }

  @Test
  public void getPriceSuccess() {
    bun = new Bun("Ржаная", 5.2f);
    Assert.assertEquals(bun.getPrice(), 5.2f, 0);
  }
}
