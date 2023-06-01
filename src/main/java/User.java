public class User {
    private final String id;
    public String name = "";
    public String lastName = "";
    public int age = 0;

    public User(String id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
