package database;

import model.User;

public class UserDB {
    private final User[] users = new User[2];
    public UserDB(){
        this.users[0] = new User("kasia",
                "kasia1Tl8*G3Ertpxvj0%8qpy",
                User.Role.USER);
        this.users[1] = new User("admin",
                "admin1Tl8*G3Ertpxvj0%8qpy",
                User.Role.ADMIN);
    }

    public User[] getUsers() {
        return users;
    }

    public User findUserByLogin(String login){
        for (User user : this.users){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
}
