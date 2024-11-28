package As2;

public class As2_Team {
    private String name;
    private String location;
    private String conference;
    private String division;
    private int cupWon; //last year the stanley cup was won
    private int cupNum;
    private int years; //when the team joined the NHL, in their current city

    public As2_Team( String n, String l, String c, String d, int w, int num, int y ){
        name = n;
        location = l;
        conference = c;
        division = d;
        cupWon = w;
        cupNum = num;
        years = y;
    }

    public void printMe(){
        System.out.println("Name: " + name + " location: " + location + " conference: " + conference + " division: " + division + " Year last Stanley cup was won: " + cupWon + " Stanley cups won: " + cupNum + " joined NHL: " + years);
    }

}
