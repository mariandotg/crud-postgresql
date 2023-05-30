import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Users", user, password);
            System.out.println("conectado con exito");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
