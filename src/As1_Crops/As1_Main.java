package As1_Crops;

import java.util.ArrayList;

public class As1_Main {
    public static void run(){
        Scanner input = new Scanner(System.in);
        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(  new As1_Crop( "Spring Wheat", 58.1 , "bushels", 6.30)  );
        allCrops.add(  new As1_Crop( "Sugar Beets", 34.9 , "tons", 781.0)  );
        allCrops.add(  new As1_Crop( "Barley", 75.9 , "bushels", 5.25)  );
        allCrops.add(  new As1_Crop( "Canola", 38.1 , "bushels", 16.44)  );
        allCrops.add(  new As1_Crop( "Mustard Seed", 14.3 , "bushels", 220.24)  );

        //totals to 1000
        allCrops.get(0).setAcres(  350  );
        allCrops.get(1).setAcres(   200   );
        allCrops.get(2).setAcres(  50  );
        allCrops.get(3).setAcres(  150 );
        allCrops.get(4).setAcres(  250  );

        while(true){
            System.out.println("1. Print farm summary");
            System.out.println("2. Search and harvest a crop");
            System.out.println("3. Get total revenue");
            System.out.println("4. Plant a crop");
            System.out.println("5. Exit");

            int choice = input.nextInt();
            input.nextLine();
            if(choice == 1){
                System.out.println("Farm Summary: ");
                for (As1_Crop crop: allCrops) {
                    crop.printMe();
                }
            }//choice 1
            else if(choice == 2){

            }
            else if(choice == 3){

            }
            else if(choice == 4){

            }
            else if(choice == 5){
                break;
            }

        }//while



    }//run

    public static void printMe(As1_Crop crop){
        System.out.println( crop.toString() );
    }

}//class
