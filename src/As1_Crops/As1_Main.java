package As1_Crops;
import java.util.Scanner;
import java.util.ArrayList;

public class As1_Main {
    public static void run(){
        
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
        
        double totalRevenue = 0;
        Scanner input = new Scanner(System.in);

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
                System.out.println("Enter the name of the crop: ");
                String answer = input.nextLine();
                As1_Crop crop = searchByName(allCrops, answer);

                if(crop == -1){
                    System.out.println("Error crop not found.");
                }else{
                    crop.printMe();
                    System.out.println("Do you want to harvest this crop? (yes or no)");
                    String answer2 = input.nextLine().toLowerCase();

                    if(answer2.equals("yes")){
                        double harvestValue = crop.harvest();
                        totalRevenue += harvestValue;
                        System.out.println("Revenue added to total: $" + harvestValue);
                    }else{
                        System.out.println("no harvest");
                    }
                }
            }
            else if(choice == 3){
                System.out.println("Total revenue from all harvested crops: $" + totalRevenue);
            }
            else if(choice == 4){
                System.out.println("Enter the name of the crop to plant: ");
                String cropName = input.nextLine();
                As1_Crop crop = searchByName(allCrops, cropName);

                if(crop != -1){
                    System.out.println("Enter the number of acres to plant: ");
                    int plantAcres = input.nextInt();
                    crop.addAcres(plantAcres);
                    System.out.println("Updated acres for " + cropName + ": " + crop.getAcres());
                } else{
                    System.out.println("Enter the yield for the crop: ");
                    double plantYield = input.nextDouble();
                    input.nextLine();
                    System.out.println("Enter the units (bushels, tons, etc.): ");
                    String plantUnits = input.nextLine();
                    System.out.print("Enter the price per unit: ");
                    double plantPrice = input.nextDouble();
                    input.nextLine();

                    As1_Crop newCrop = new As1_Crop(cropName, plantYield, plantUnits, plantPrice);
                    System.out.println("Enter the number of acres to plant: ");
                    int plantAcres = input.nextInt();
                    newCrop.setAcres(plantAcres);
                    allCrops.add(newCrop);
                    System.out.println("New crop " + cropName + " added with " + plantAcres + " acres.");
                }
            }
            else if(choice == 5){
                break;
            }

        }//while



    }//run

    private static As1_Crop searchByName(ArrayList<As1_Crop> crops, String name) {
        for (As1_Crop crop : crops) {
            if (crop.getName().equalsIgnoreCase(name)) {
                return crop; // Return the crop if found
            }
        }
        return -1; 
    }


}//class
