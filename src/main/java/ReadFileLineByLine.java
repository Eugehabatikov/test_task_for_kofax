import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = getConnection();
            File file = new File("C:/Users/evgenii/PREFERENCE_DEFINITION.csv");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String csvVersion = reader.readLine();
            String tableName = reader.readLine().replace("\"\"", "").split(";")[1];
            tableName = tableName.substring(0, tableName.length() - 1);
            String columnsLine = reader.readLine();
            String[] columns = columnsLine.substring(columnsLine.indexOf(';') + 1)
                    .replace("\"\"", "").split(";");
            String columnsResult = "";
            for (String column : columns) {
                columnsResult = columnsResult + column + ",";
            }
            columnsResult = columnsResult.substring(0, columnsResult.length() - 2);
            Statement statement = conn.createStatement();
            statement.executeUpdate(getCreateTableQuery());

            String line = reader.readLine();
            while (line != null) {
                String[] cells = line.substring(line.indexOf(';') + 1).replace("\"\"", "").split(";");
                String lineResult = "";
                for (String cell : cells) {
                    lineResult = lineResult + cell + ",";
                }
                lineResult = lineResult.substring(0, lineResult.length() - 2);
                String newLine = "INSERT INTO " + tableName + " (" + columnsResult + ") VALUES (" + lineResult + ") ";
                statement.executeUpdate(newLine);
                line = reader.readLine();
            }
            System.out.println("CSV was added correctly");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | IllegalAccessException | ClassNotFoundException | InvocationTargetException |
                 InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static String getCreateTableQuery() throws IOException {
        File file = new File("C:/tmp/test_task_for_kofax/table.creation");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder query = new StringBuilder();
        while (line != null) {
            query.append(line);
            line = reader.readLine();
        }
        return query.toString();
    }
}