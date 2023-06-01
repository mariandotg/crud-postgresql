public class User {
    private final long id;
    public String name = "";
    public String lastName = "";
    public int age = 0;

    public User(long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
