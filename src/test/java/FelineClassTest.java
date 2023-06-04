import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineClassTest {
    Feline feline = new Feline();
    Feline felineSpy = Mockito.spy(feline);
    @Test
    public void felineEatMeatTest () throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, felineSpy.eatMeat());
    }
    @Test
    public void felineGetFamilyTest(){
        String expected = "Кошачьи";
        Assert.assertEquals(expected, felineSpy.getFamily());
    }
    @Test
    public void felineGetKittensTest(){
        felineSpy.getKittens();
        Mockito.verify(felineSpy,Mockito.times(1)).getKittens();
    }
}
