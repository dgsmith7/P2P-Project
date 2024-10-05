
import java.util.Scanner;

public class TextUI {

    private static final Scanner in = new Scanner(System.in);

    public TextUI() {
    }

    public String getInput(String _prompt) {
        String newInput;
        System.out.print(_prompt);
        newInput = in.nextLine();
        return newInput;
    }

    public String[] getArgs(String[] _inputArray) {
        String[] outputArray = new String[_inputArray.length - 1];
        for (int i = 0; i < _inputArray.length; i++) {
            if (i > 0) {
                outputArray[i - 1] = _inputArray[i];
            }
        }
        return outputArray;
    }

}
