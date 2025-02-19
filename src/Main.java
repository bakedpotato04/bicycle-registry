import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main class models the main menu. The user can pick from 6
 * different options. The main menu only closes when the user
 * exits the program.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("******************************************");
        System.out.println("* Bike Registry by Brandon Wong sn 301569839 *");
        System.out.println("******************************************");

        int num;
        int chosenBikeID;
        int bikeID;
        String owner;
        int wheelSize;
        String brakeType;
        String type;
        String serialNum;
        Registry newRegistry = new Registry();
        do {
            Registry.displayMainMenu();
            Scanner input = new Scanner(System.in);
            num = input.nextInt();
            input.nextLine();

            if(num == 1){
                newRegistry.displayAllBikes();
            }
            else if(num == 2){
                try {
                    System.out.println("Enter Bike owner name:");
                    owner = input.nextLine();
                    System.out.println("Enter Bike type:");
                    type = input.nextLine();
                    System.out.println("Enter Bike's serial number:");
                    serialNum = input.nextLine();
                    System.out.println("Enter Bike's brake type:");
                    brakeType = input.nextLine();
                    System.out.println("Enter Bike's wheel size:");
                    wheelSize = input.nextInt();

                    Bicycle newBike = new Bicycle(newRegistry.getId(),owner, wheelSize, type, serialNum,brakeType);
                    newRegistry.addNewBike(newBike);
                }catch (InputMismatchException exception){
                    System.out.println("Invalid input");
                }



            }
            else if(num == 3){

                try {
                    int bikeCount = newRegistry.getNumberOfBikes();
                    while(bikeCount == newRegistry.getNumberOfBikes()){
                        newRegistry.displayAllBikes();
                        System.out.println("Enter ID (0 to cancel)");
                        chosenBikeID = input.nextInt();
                        if(chosenBikeID == 0){
                            break;
                        }
                        newRegistry.deleteBike(chosenBikeID);
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Invalid input");
                }


            }
            else if(num == 4){
                Bicycle alteredBike;
                newRegistry.displayAllBikes();
                chosenBikeID = -1;
                while(chosenBikeID != 0){
                    System.out.println("Enter ID (0 to cancel)");
                    chosenBikeID = input.nextInt();
                    input.nextLine();
                    for(Bicycle bike : newRegistry.registry){
                        if(bike.getBikeID() == chosenBikeID){
                            alteredBike = bike;
                            System.out.println("Which Attribute?");
                            String attribute = input.nextLine().toLowerCase();
                            newRegistry.alterBike(attribute, alteredBike, input);
                            chosenBikeID = 0;
                            System.out.println("Saved!");
                            break;

                        }
                    }
                }

            }
            else if(num == 5){
                //getPackage and getName
                //getClass and getName
                //package name
                int i = 1;
                System.out.println("All Bike objects:");
                for(Bicycle bike : newRegistry.registry){
                    System.out.println(i + ". src." +bike.getClass().getName() + "[Id:" + bike.getBikeID() + ", Owner:" + bike.getOwner() + ", type:"+bike.getType()+",");
                    System.out.println("Serial:" + bike.getSerialNum() + ", Brake:" + bike.getBrakeType() + ", WheelSize:" + bike.getWheelSize()+"]");
                }
            }
        }
        while (num != 6);
    }
}
