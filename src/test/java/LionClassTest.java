import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionClassTest {
    private final String SEX;
    private final boolean HAS_MANE;
    private final String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
    public LionClassTest(String sex, boolean hasMane) throws Exception {
        this.SEX = sex;
        this.HAS_MANE = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getSex(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void lionConstructorTest() throws Exception {
        Lion lion = new Lion(SEX);
        Lion lionSpy = Mockito.spy(lion);
    }
    @Test
    public void lionConstructionExceptionTest(){

    }
    @Test
    public void lionHasManeTest() throws Exception {
        Lion lion = new Lion(SEX);
        Lion lionSpy = Mockito.spy(lion);
        try{
            lionSpy.doesHaveMane();
            Mockito.verify(lionSpy, Mockito.times(1)).doesHaveMane();
            Assert.assertEquals(HAS_MANE, lionSpy.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals(expectedMessage, exception.getMessage());
        }
    }
    @Test
    public void lionGetKittensTest() throws Exception {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion(SEX);
            Lion lionSpy = Mockito.spy(lion);
            lionSpy.getKittens();
            Mockito.verify(lionSpy, Mockito.times(1)).getKittens();
        } catch (Exception exception) {
            Assert.assertEquals(expectedMessage, exception.getMessage());
        }
    }
    @Test
    public void lionGetFoodTest () throws Exception {
        try{
            Lion lion = new Lion(SEX);
            Lion lionSpy = Mockito.spy(lion);
            lionSpy.getFood();
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.verify(lionSpy, Mockito.times(1)).getFood();
            Assert.assertEquals(expected, lionSpy.getFood());
        } catch (Exception exception) {
            Assert.assertEquals(expectedMessage, exception.getMessage());
        }
    }
}
