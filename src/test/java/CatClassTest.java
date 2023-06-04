import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class CatClassTest {
    @Mock
    Feline felineMock = Mockito.mock(Feline.class);
    Cat cat = new Cat (felineMock);
    Cat catSpy = Mockito.spy(cat);
    @Test
    public void catGetSoundTest(){
        Assert.assertEquals("Мяу", catSpy.getSound());
    }
    @Test
    public void catGetFoodTest() throws Exception {
        catSpy.getFood();
        Mockito.verify(catSpy, Mockito.times(1)).getFood();
    }
}
