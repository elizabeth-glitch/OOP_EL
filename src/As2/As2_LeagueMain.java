package As2;

import Examples.Ex3_Client;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class As2_LeagueMain {
    public static void run(){
        ArrayList<As2_Team> allTeams = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        loadFile("data/TeamsData.csv", allTeams);
        allTeams.add(  new As2_Team( "Los Angeles Kings", "Los Angeles", "Western", "Pacific", 2014, 2, 1967 )  );
        //player name, ID, goalsScored, points, salary
        allTeams.get(0).addPlayer("Connor McDavid", 97, 14, 38, 12500000.00);
        allTeams.get(0).addPlayer("Ryan Nugent-Hopkins", 93, 4, 14, 5125000.00);
        allTeams.get(0).addPlayer("Darnell Nurse", 25, 3, 11, 9250000.00);
        allTeams.get(0).addPlayer("Leon Draisaitl", 29, 20, 38, 8500000.00);
        allTeams.get(0).addPlayer("Evan Bouchard", 2, 6, 20, 3900000.00);
        allTeams.get(1).addPlayer("Jonathan Huberdeau", 10, 10, 19, 10500000.00);
        allTeams.get(1).addPlayer("Rasmus Andersson", 4, 6, 15, 4550000.00);
        allTeams.get(1).addPlayer("Daniil Miromanov", 62, 1, 6, 1250000.00);
        allTeams.get(1).addPlayer("Andrei Kuzmenko", 96, 1, 10, 5500000.00);
        allTeams.get(1).addPlayer("Justin Kirkland", 58, 2, 8, 775000.00);
        allTeams.get(5).addPlayer("Auston Matthews", 34, 0, 0, 775000.00);
        allTeams.get(5).addPlayer("Mitchell Marner", 16, 0, 0, 0.0);
        allTeams.get(5).addPlayer("Anthony Stolarz", 41, 0, 0, 0.0);
        allTeams.get(3).addPlayer("Quinn Hughes", 43, 0, 0, 0.0);
        allTeams.get(3).addPlayer("Elias Pettersson", 40, 0, 0, 0.0);
        allTeams.get(3).addPlayer("Thatcher Demko", 35, 0, 0, 0.0);
        allTeams.get(3).addPlayer("Broch Boeser", 6, 0, 0, 0.0);
        allTeams.get(8).addPlayer("Matthew Tkachuk", 19, 0, 0, 0.0);
        allTeams.get(8).addPlayer("Aleksander Barkov", 16, 0, 0, 0.0);
        allTeams.get(8).addPlayer("Sergei Bobrovsky", 72, 0, 0, 0.0);
        allTeams.get(8).addPlayer("Sam Reinhart", 13, 0, 0, 0.0);

        while(true){
            System.out.println("Menu: ");
            System.out.println("1. Print list of teams");
            System.out.println("2. Find highest");
            System.out.println("3. View division");
            System.out.println("4. Sort by Stanley Cup win ");
            System.out.println("5. Update Cup Status");
            System.out.println("6. Exit and save");
            System.out.println("7. Print players");
            System.out.println("8. Total Team Player stats");
            System.out.println("9. Update player stat");

            int answer = input.nextInt();
            if(answer == 1){
                System.out.println("NHL Teams");
                for (int i = 0; i<allTeams.size(); i++) {
                    allTeams.get(i).printMe();
                }
            }//1
            if(answer == 2){
                As2_Team highestCupWon = allTeams.get(0);
                As2_Team highestCupNum = allTeams.get(0);
                As2_Team newestTeam = allTeams.get(0);
                for(As2_Team team: allTeams){
                    if(team.getCupWon() > highestCupWon.getCupWon()){
                        highestCupWon = team;
                    }
                    if(team.getCupNum() > highestCupNum.getCupNum()){
                        highestCupNum = team;
                    }
                    if(team.getYears() > newestTeam.getYears()){
                        newestTeam = team;
                    }
                }
                System.out.println("Statistics Highest");
                System.out.println("Team with the most recent Stanley Cup win: " + highestCupWon.getName() + " (" + highestCupWon.getLocation() + "), Year: " + highestCupWon.getCupWon());
                System.out.println("Team with the most Stanley Cups: " + highestCupNum.getName() + " (" + highestCupNum.getLocation() + "), Cups: " + highestCupNum.getCupNum());
                System.out.println("Newest team in the NHL: " + newestTeam.getName() + " (" + newestTeam.getLocation() + "), Year: " + newestTeam.getYears());

            }//2
            if(answer == 3) { // view division
                System.out.println("What division do you want to view?");
                input.nextLine();
                String answer1 = input.nextLine();
                
                boolean found = false;
                System.out.println("Teams in the division " + answer1 + ":");
                for(As2_Team team : allTeams){
                    if(  answer1.equalsIgnoreCase( team.getDivision() )  ){
                        System.out.println("Name: " + team.getName() + " Conference: " + team.getConference() );
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("No teams found in the division");
                }

            }//3
            if(answer == 4){ // Sort by most recent Stanley Cup win
                for (int i = 0; i < allTeams.size() - 1; i++) {
                    int mostRecentIndex = i;

                    for (int j = i + 1; j < allTeams.size(); j++) {
                        if (allTeams.get(j).getCupWon() > allTeams.get(mostRecentIndex).getCupWon()) {
                            mostRecentIndex = j;
                        }
                    }

                    if (mostRecentIndex != i) {
                        As2_Team tempTeam = allTeams.get(i);
                        allTeams.set(i, allTeams.get(mostRecentIndex));
                        allTeams.set(mostRecentIndex, tempTeam);
                    }
                }

                System.out.println("Teams sorted by most recent Stanley Cup win:");
                for (As2_Team team : allTeams) {
                    System.out.println("Name: " + team.getName() + ", Last Cup: " + team.getCupWon());
                }
            }
            if(answer == 5){
                System.out.println("Enter the name of the team you want to update:");
                input.nextLine(); // Consume leftover newline
                String teamName = input.nextLine();

                boolean teamFound = false;
                for (As2_Team team : allTeams) {
                    if (team.getName().equalsIgnoreCase(teamName)) {
                        teamFound = true;

                        System.out.println("What would you like to update?");
                        System.out.println("1. Year of last Stanley Cup win");
                        System.out.println("2. Number of Stanley Cups won");
                        int updateChoice = input.nextInt();

                        if (updateChoice == 1) {
                            System.out.println("Enter the new year of the last Stanley Cup win:");
                            int newYear = input.nextInt();
                            team.setCupWon(newYear);
                            System.out.println("Updated " + team.getName() + ": Last Stanley Cup win is now " + newYear);
                        } else if (updateChoice == 2) {
                            System.out.println("Enter the new number of Stanley Cups won:");
                            int newCount = input.nextInt();
                            team.setCupNum(newCount);
                            System.out.println("Updated " + team.getName() + ": Stanley Cups won is now " + newCount);
                        } else {
                            System.out.println("Invalid choice. No updates made.");
                        }
                        break;
                    }
                }

                if (!teamFound) {
                    System.out.println("Team not found.");
                }
            }
            if(answer == 6){
                saveFile("data/TeamsData.csv", allTeams);
                break;
            }
            if(answer == 7){
                System.out.println("Enter the name of the team: ");
                input.nextLine();
                String teamN = input.nextLine();
                boolean found = false;
                for(As2_Team team: allTeams){
                    if(team.getName().equalsIgnoreCase(teamName)){
                        team.printMyPlayers();
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Team not found");
                }
            }
            if(answer == 8){
                System.out.println("Team Goal Scored stats: ");
                for(As2_Team team : allTeams){
                    System.out.println(team.getName() + ": " + team.getTotalPlayerStats() + " total goals");
                }
            }
            if(amswer == 9){
                System.out.println("Enter the name of the player to update");
                input.nextLine();
                String playerName = input.nextLine();
                boolean found = false;
                for(As2_Team team : allTeams){
                    for(As3_Player player : team.players){
                        if(player.getName().equalsIgnoreCase(playerName)){
                            player.updateStat();
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        break;
                    }
                }
                if(!found){
                    System.out.println("Player not found");
                }
            }//9
        }//while
    }//run

    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As2_Team(  tempArray[0],tempArray[1], tempArray[2], tempArray[3], Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6])   ));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <As2_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getLocation();
                toSave += "," + tempList.get(i).getConference();
                toSave +="," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getCupNum();
                toSave +="," + tempList.get(i).getCupWon();
                toSave +="," + tempList.get(i).getYears();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile



}//class
