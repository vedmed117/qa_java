import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Используем параметризованные тесты для класса Lion
@RunWith(Parameterized.class)
public class LionTest {

    // Поля для параметров теста
    private final String sex;
    private final boolean expectedHasMane;
    private final int expectedKittens;

    // Конструктор для параметризованных тестов
    public LionTest(String sex, boolean expectedHasMane, int expectedKittens) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedKittens = expectedKittens;
    }

    // Параметры
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true, 2}, // Проверка для льва
                {"Самка", false, 3} // Проверка для львицы
        });
    }

    // Проверка наличия гривы у льва
    @Test
    public void doesHaveManeParameterizedTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    // Тест для проверки количества котят
    @Test
    public void getKittensParameterizedTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedKittens, lion.getKittens());
    }

    // Тест для проверки недопустимого значения пола льва
    @Test(expected = Exception.class)
    public void invalidSexTest() throws Exception {
        new Lion("Invalid", Mockito.mock(Feline.class));
    }

    // Тест для проверки получения еды
    @Test
    public void getFoodTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, feline);
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
