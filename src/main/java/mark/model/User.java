package mark.model;

public class User {

    private int userID;
    private String username;
    private String role;

    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.role = role;

    }

    public int getUserID() { return userID; }
    public String getUsername() { return username; }
    public String getRole() { return role; }

    public void setUserID(int userID) { this.userID = userID; }
    public void setUsername(String username) { this.username = username; }
    public void setRole(String role) { this.role = role; }
}
