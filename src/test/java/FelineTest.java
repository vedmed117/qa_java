import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensDefaultTest() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void getKittensWithCountTest() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);
        Assert.assertEquals(3, kittens);
    }
}
