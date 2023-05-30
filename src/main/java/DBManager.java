import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String user = dotenv.get("DB_USER");
    private static final String password = dotenv.get("DB_PASSWORD");

    public static void initConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Users", user, password);
            System.out.println("conectado con exito");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
