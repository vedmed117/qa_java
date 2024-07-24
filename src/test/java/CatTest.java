import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CatTest {

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(new Feline());
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        List<String> food = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
