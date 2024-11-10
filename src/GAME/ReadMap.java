package GAME;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMap {

    public static String loadFile(String path) throws InvalidFileException { //statica sa o pot accesa de oriunde
        StringBuilder builder = new StringBuilder(); //cu StringBuilder adaug caractere unui string
        try {
            BufferedReader b = new BufferedReader(new FileReader(path));
            String line;
            while ((line = b.readLine()) != null) { //citesc linie cu linie din map
                builder.append(line + "\n");
            }
            b.close();

        } catch (Exception e) {
            throw new InvalidFileException("The file was not found!");
        }
        return builder.toString();
    }
    public static int ToInt(String number) { // o sa apelez ReadMap.parseInt
        try {
            return Integer.parseInt(number);
        } catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

}
