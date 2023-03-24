import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/evgenii/PREFERENCE_DEFINITION.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String csvVersion = reader.readLine();
            String tableName = reader.readLine();
            String columns = reader.readLine();
            // создать таблицу и колонки CREATE IF NOT EXSIST
            String line = reader.readLine();
            while (line != null) {
                // парсим строку, записываем, результат сразу записываем в бд
                String[] cells = line.replace("\"\"","").split(";");
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}