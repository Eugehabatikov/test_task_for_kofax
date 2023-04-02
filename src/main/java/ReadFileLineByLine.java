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
            Connection connection = getConnection();
            File file = new File("PREFERENCE_DEFINITION.csv");
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
            columnsResult = columnsResult.substring(0, columnsResult.length() - 2)
                    .replace("PREFERENCE_DOMAIN_ID.PREFERENCE_DOMAIN_NAME",
                            "`PREFERENCE_DOMAIN_ID.PREFERENCE_DOMAIN_NAME`");
            Statement statement = connection.createStatement();
            statement.executeUpdate(getCreateTableQuery());

            String line = reader.readLine();
            while (line != null) {
                line = line.substring(0, line.length() - 2);
                List<String> rawData = new ArrayList<>(Arrays.asList(line.split("\";\"")));
                rawData.remove(0);
                TableLine lineObject = new TableLine(rawData);
                String newLine = "INSERT INTO "
                        + tableName + " (" + columnsResult + ") VALUES (" + TableLine.inputValue(lineObject) + ") ";
                statement.executeUpdate(newLine);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | IllegalAccessException | ClassNotFoundException | InvocationTargetException |
                 InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return do connection to server
     */
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

    /**
     *
     * @return query data for create table in String format
     */
    public static String getCreateTableQuery() throws IOException {
        File file = new File("table.creation");
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