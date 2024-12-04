package As2;

public class As2_Player {
    private String name;
    private int playerID;
    private int goalsScored;
    private int points;
    private double salary;

    public As2_Player( String n, int id, int g, int p, double s ){
        name = n;
        playerID = id;
        goalsScored = g;
        points = p;
        salary = s;
    }

    public void printMe(){
        System.out.println("Player: " + name + " playerID: " + playerID + " goals: " + goalsScored + " points: " + points + " salary: " + salary);
    }

}
