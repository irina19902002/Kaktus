import java.util.Random;
import java.util.random.RandomGenerator;

public class Detector {
    public  static  int humidity;
    public static  int GetHumidity(){
        Random r = new Random();
        return humidity = r.nextInt(0,30);
    }
}
