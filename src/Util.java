import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lexer on 16.10.14.
 */
public class Util {
    public static void print(String text) {
        System.out.println(text);
    }

    public static int scanInt() {
        int result = -1;
        BufferedReader bufferRead = null;
        try {
            bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            result = Integer.parseInt(s);

        } catch (IOException e) {
            print("Ошибка чтения int");
        } catch (NumberFormatException e) {
            print("Ошибка. Введено не число");
        }

        return result;
    }
}
