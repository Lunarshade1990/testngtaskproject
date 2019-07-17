import com.lunarshade.testapp.ResponseSingleton;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChangeMethodTestClass extends Assert {

    private ResponseSingleton responseSingleton;

    @BeforeClass
    private void setUp() {
        responseSingleton = new ResponseSingleton();
        responseSingleton.populate();
    }


    @Parameters({"index", "value"})
    @Test
    public void testChangeMethod(int i, String value) {
        responseSingleton.change(i, value);
        String current = responseSingleton.getByIndex(i);
        assertEquals(current, value);
    }
}
