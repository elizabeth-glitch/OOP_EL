package As2;

import java.util.ArrayList;

public class As2_Team {
    private String name;
    private String location;
    private String conference;
    private String division;
    private int cupWon; //last year the stanley cup was won
    private int cupNum;
    private int years; //when the team joined the NHL, in their current city

    private ArrayList<As2_Player> allPlayers;
    public void addPlayer( String n, int id, int g, int p, double s ){
        allPlayers.add( new As2_Player( n, id, g, p, s ) );
    }
    public void printPlayers(){
        System.out.println("Players on " + name + ":");
        for(As2_Player player : allPlayers){
            player.printMe();
        }
    }

    public ArrayList<As2_Player> getPlayers(){
        return allPlayers;
    }

    public int getTotalPlayerStats(){
        int totalGoals = 0;
        for(As2_Player player : allPlayers){
            totalGoals += player.getGoalsScored();
        }
        return totalGoals;
    }

    public As2_Team( String n, String l, String c, String d, int w, int num, int y ){
        name = n;
        location = l;
        conference = c;
        division = d;
        cupWon = w;
        cupNum = num;
        years = y;
        allPlayers = new ArrayList<>();
    }

    public void printMe() {
        System.out.println("Name: " + name + " location: " + location + " conference: " + conference + " division: " + division + " Year last Stanley cup was won: " + cupWon + " Stanley cups won: " + cupNum + " joined NHL: " + years);
    }

    public String getConference(){
        return conference;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDivision() {
        return division;
    }

    public int getCupWon() {
        return cupWon;
    }

    public int getCupNum() {
        return cupNum;
    }

    public int getYears() {
        return years;
    }

    public void setCupWon(int cupWon) {
        this.cupWon = cupWon;
    }

    public void setCupNum(int cupNum) {
        this.cupNum = cupNum;
    }

}
