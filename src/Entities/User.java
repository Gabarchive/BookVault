package Entities;

/**
 * Represents a user of the library system.
 */
public class User {

    private String name;

    // Constructor to initialize a user
    public User(String name) {
        this.name = name;
    }

    // Returns the user name
    public String getName() {
        return name;
    }

    // String representation of the user
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}