import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBManager {
    private static final Dotenv dotenv = Dotenv.load();
    private static Connection connection;

    private static final String user = dotenv.get("DB_USER");
    private static final String password = dotenv.get("DB_PASSWORD");

    public static void initConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Users", user, password);
            System.out.println("conectado con exito");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void insertUser(String name, String lastName, int age) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO userInfo (name,lastName,age) VALUES (?,?,?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
