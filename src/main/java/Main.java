import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DBManager.initConnection();

        int option;

        do {
            System.out.println("\n1. ver usuarios");
            System.out.println("2. crear usuario");
            System.out.println("3. editar usuario");
            System.out.println("4. borrar usuario");
            System.out.println("5. finalizar programa");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("elegiste el número 1");
                    getUsers();
                    break;
                case 2:
                    System.out.println("elegiste el número 2");
                    createUser();
                    break;
                case 3:
                    System.out.println("elegiste el número 3");
                    break;
                case 4:
                    System.out.println("elegiste el número 4");
                    break;
            }
        } while (option != 5);
    }

    public static void createUser() {
        System.out.println("Ingresa un nombre");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("Ingresa un apellido");
        String lastName = scanner.nextLine();

        System.out.println("Ingresa edad");
        int age = scanner.nextInt();

        DBManager.insertUser(name, lastName, age);
    }

    public static void getUsers() {
        DBManager.getUsers();
    }
}
