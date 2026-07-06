package Services;

import Entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Service responsible for managing users.
 */
public class UserService {

    private List<User> users = new ArrayList<>();

    // Adds a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Finds a user by name
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}