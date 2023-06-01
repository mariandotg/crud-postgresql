import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

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

    public static void getUsers() {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from userInfo order by id");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                int age = result.getInt("age");

                User user = new User(id, name, lastName, age);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(long id, String newName, String newLastName, int newAge) {
        try {
            PreparedStatement statement = connection.prepareStatement("update userInfo set name = ?, lastName = ?, age = ? where id = ?");
            statement.setString(1, newName);
            statement.setString(2, newLastName);
            statement.setInt(3, newAge);
            statement.setLong(4, id);

            int row = statement.executeUpdate();

            if(row == 0) {
                System.out.println("no se pudo modificar");
            } else {
                System.out.println("se modificó correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
