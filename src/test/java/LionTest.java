import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class LionTest {

    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        new Lion("Invalid", feline);
    }

    @Test
    public void getKittensTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", feline);
        int kittens = lion.getKittens();
        Assert.assertEquals(2, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
