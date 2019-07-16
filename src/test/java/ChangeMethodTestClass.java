import org.testng.Assert;
import org.testng.annotations.*;

public class ChangeMethodTestClass extends Assert {

    private ResponseSingleton responseSingleton;
    private int index = 1;
    private String value = "test";

    public ChangeMethodTestClass(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public ChangeMethodTestClass() {
    }

    @BeforeClass
    private void setUp() {
        responseSingleton = new ResponseSingleton();
        responseSingleton.populate();
    }


    @DataProvider
    public Object[][] testChangeData() {
        return new Object[][]{
                {index, value}
        };
    }

    @Test(dataProvider = "testChangeData")
    public void testChangeMethod(int i, String value) {

        responseSingleton.change(i, value);
        String current = responseSingleton.getByIndex(i);
        assertEquals(current, value);
    }
}
