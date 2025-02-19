import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Registry class models the list of bicycle objects inputted by the
 * user. Data includes the number of bikes and the bicycle List. It
 * supports adding, altering and deleting bikes, displaying main menu,
 * and displaying all bikes.
 */
public class Registry {
    List<Bicycle> registry = new ArrayList<>();
    private int id = 1;
    private int numberOfBikes = 0;

    public void addNewBike(Bicycle newBike){
        registry.add(newBike);
        numberOfBikes++;
        id++;
    }

    public void deleteBike(int id){
        Bicycle bikeToDelete;
        for(Bicycle bike : registry){
            if(bike.getBikeID() == id){
                bikeToDelete = bike;
                registry.remove(bikeToDelete);
                numberOfBikes--;
                return;
            }
        }
        //throw new NoSuchElementException("MessageString");
    }

    public static void displayMainMenu(){
        System.out.println("*************");
        System.out.println("* Main Menu *");
        System.out.println("*************");
        System.out.println("1. List Bikes");
        System.out.println("2. Add a new Bike");
        System.out.println("3. Remove a Bike");
        System.out.println("4. Change Bike attribute");
        System.out.println("5. DEBUG: Dump objects (toString)");
        System.out.println("6. Exit");
    }

    public void displayAllBikes(){
        //int end = numOfBicycles;
        System.out.println("******************");
        System.out.println("* List of Bikes: *");
        System.out.println("******************");
        System.out.println("ID  Owner,           Type,      Serial,     Brake,  Wheel Size");
        for (Bicycle bike : registry) {
            System.out.println(bike.getBikeID() + "   " + bike.getOwner() + ",   " + bike.getType() + ",  " + bike.getSerialNum() + ",  " + bike.getBrakeType() + ",   " + bike.getWheelSize());
        }
    }

    public void alterBike(String attribute, Bicycle alteredBike, Scanner input){
        switch (attribute) {
            case "owner":
                System.out.println("Enter new owner name:");
                alteredBike.setOwner(input.nextLine());
                break;
            case "type":
                System.out.println("Enter new bike type:");
                alteredBike.setType(input.nextLine());
                break;
            case "serial":
                System.out.println("Enter new serial number:");
                alteredBike.setSerialNum(input.nextLine());
                break;
            case "braketype":
                System.out.println("Enter new brake type:");
                alteredBike.setBrakeType(input.nextLine());
                break;
            case "wheel size":
                System.out.println("Enter new wheel size:");
                alteredBike.setWheelSize(input.nextInt());
                input.nextLine(); // consume the newline
                break;
            default:
                System.out.println("Invalid attribute.");
        }
        //break;
    }

    // getters
    public int getId() {
        return id;
    }

    public int getNumberOfBikes() {
        return numberOfBikes;
    }
}
