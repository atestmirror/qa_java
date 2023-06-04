import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
@RunWith(Parameterized.class)
public class LionClassTest {
    private String SEX;
    private boolean HAS_MANE;
    public LionClassTest(String sex, boolean hasMane) throws Exception {
        this.SEX = sex;
        this.HAS_MANE = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getSex(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
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
    public void lionHasManeTest() throws Exception {
        Lion lion = new Lion(SEX);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.doesHaveMane();
        Mockito.verify(lionSpy, Mockito.times(1)).doesHaveMane();
        Assert.assertEquals(HAS_MANE, lionSpy.doesHaveMane());
    }
    @Test
    public void lionGetKittensTest() {
        Feline feline = new Feline();
        Feline felineSpy = Mockito.spy(feline);
        Lion lion = new Lion(feline);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getKittens();
        Mockito.verify(lionSpy,Mockito.times(1)).getKittens();
    }
    @Test
    public void lionGetFoodTest() throws Exception {
        Feline feline = new Feline();
        Feline felineSpy = Mockito.spy(feline);
        Lion lion = new Lion(felineSpy);
        Lion lionSpy = Mockito.spy(lion);
        lionSpy.getFood();
        Mockito.verify(lionSpy,Mockito.times(1)).getFood();
    }
}
