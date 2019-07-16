import java.util.ArrayList;
import java.util.List;

public class ResponseSingleton {

    private static ResponseSingleton instance;
    private List<String> responseList = new ArrayList<>();
    private int size = 100;

    public static synchronized ResponseSingleton getInstance() {
        if (instance == null) {
            instance = new ResponseSingleton();
        }

        return instance;
    }

    public void populate() {
        for (int i = 0; i < 100; i++) {
            responseList.add(getRandomResponseFromTwo("Pass", "Fail"));
        }
    }

    public String get() {
        int randomIndex = (int) (Math.random() * (size+1));
        return responseList.get(randomIndex);
    }

    protected String getByIndex(int i) {
        return responseList.get(i);
    }

    public synchronized void change(int i, String s) {
        responseList.set(i, s);
    }

    private String getRandomResponseFromTwo(String s1, String s2) {

        double random = Math.random();

        if (random<0.5) return s1;
        else return s2;
    }
}
