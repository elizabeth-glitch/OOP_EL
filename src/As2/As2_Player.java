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

    public String toString(){
        return "Name: " + name + ", Player ID: " + playerID + ", Goals scored: " + goalsScored + ", points: " + points + ", salary: " + salary;
    }

    public void printMe(){
        System.out.println(toString());
    }
    
    public void updateStat(){
        System.out.println("Updating " + name + "'s stats");
        goalsScored++;
        System.out.println("Goals scored: " + goalsScored);
    }

    public String getName(){
        return name;
    }

    public int getGoalsScored(){
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored){
        this.goalsScored = goalsScored;
    }

}
