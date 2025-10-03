
import java.io.*;

public class Listener implements Runnable {

    private final BufferedReader reader;

    public Listener(BufferedReader _in) throws IOException {
        this.reader = _in;
    }

    @Override
    public void run() {
        String inputString;
        try {  // waiting for a message
            while ((inputString = reader.readLine()) != null) {
                System.out.println(inputString);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
