package data.repository;

import data.model.AppUser;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, AppUser> userDB = new HashMap<>();
    public AppUser findByKey(String email) {
        return userDB.get(email);
    }

    public AppUser save(AppUser user) {
        userDB.put(user.getEmail(), user);
        return user;
    }

    public AppUser delete(String email) {
        return userDB.remove(email);
    }
}
