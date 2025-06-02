public class Admin {
    private String id;
    private String email;
    private String password;
    private boolean isAdmin;

    public Admin(String id, String email, String password, boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean checkPassword(String pw) {
        return password.equals(pw);
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public boolean isAdmin() { return isAdmin; }
}