import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetMethodTestClass extends Assert {

    private ResponseSingleton responseSingleton;

    @BeforeClass
    private void setUp() {
        responseSingleton = new ResponseSingleton();
        responseSingleton.populate();
    }

    @Test
    public void testGetMethod() {
        assertTrue(responseSingleton.get().contains("ass"));
    }
}
