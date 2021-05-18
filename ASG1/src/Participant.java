public class Participant {

    private String username;
    private int number;

    public Participant(String username, int number) {
        setUsername(username);
        setNumber(number);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
