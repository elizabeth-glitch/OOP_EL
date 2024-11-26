package As2;
import Examples.Ex3_Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class As2_LeagueMain {
    public static void run(){
        ArrayList<As2_Team> allTeams = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        loadFile("data/TeamsData.csv", allTeams);
        allTeams.add(  new As2_Team( "Los Angeles Kings", "Los Angeles", "Western", "Pacific", 2014, 2, 1967 )  );

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
