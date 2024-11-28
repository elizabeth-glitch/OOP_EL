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

        System.out.println("Menu: ");
        System.out.println("1. Print list of teams");
        System.out.println("2. Find averages");
        System.out.println("3. View Division");
        System.out.println("4. Sort by ? ");
        System.out.println("5. Update Stats");
        System.out.println("6. Exit and save");

        int answer = input.nextInt();
        while(true){
            if(answer == 1){
                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.printMe();
                }
            }//1
            if(answer == 2){

            }//2
            if(answer == 3){

            }
            if(answer == 4){

            }
            if(answer == 5){

            }
            if(answer == 6){
                //saveFile("data/TeamsData.csv", allTeams);
                break;
            }
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



}//class
