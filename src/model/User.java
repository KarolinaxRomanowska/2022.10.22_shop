package model;
import gui.Authenticator;
//import org.apache.commons.codec.digest.DigestUtils;

public class User {
    public enum Role{
        ADMIN,
        USER
    }
    private String login;
    private String password;
    private Role role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Role role) {
        this(login, password);
        this.role = role;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User)) {
            return false;
        }
        User temp = (User) obj;
        return this.login.equals(temp.login) &&
                this.password.equals(/*DigestUtils
                        .md5Hex*/(temp.password +
                                Authenticator.seed));
    }
}
