import java.util.ArrayList;
import java.util.Scanner;

public class Bicicleta {

    public static Scanner sc = new Scanner(System.in);
    //properties
    private String make;
    private String model;
    //private int maxSpeed;

    enum BikeType {FLATLAND, STREET, GRAVEL}

    private BikeType bikeType;


//getters

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }


    public BikeType getBikeType() {
        return bikeType;
    }
    //setters

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

 /*   public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }*/

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }


    //methods

    public Bicicleta(String make, String model, BikeType bikeType) {
        this.make = make;
        this.model = model;

        this.bikeType = bikeType;
    }


    @Override
    public String toString() {
        return "Bike: " +
                "make: '" + make + '\'' +
                ", model: '" + model + '\'' +
                ", bikeType: " + bikeType;
    }


    public void bell() {
        System.out.println("Rrring riing");
    }

    public void derecha() {
        System.out.println("Doblando a la derecha");
    }

    public static ArrayList newBikeArray() {
        System.out.println("\n- This method creates an ArrayList with user specified size");
        System.out.print(" Please confirm number of bikes for the new ArrayList: ");
        int initalSize = Integer.parseInt(sc.nextLine());

        ArrayList<Bicicleta> bikeArrayList = new ArrayList<>(initalSize);

        if (initalSize == 1) {
            System.out.println(" ArrayList created with " + initalSize + " place");
        } else {

            System.out.println(" ArrayList created with " + initalSize + " places");
        }
        return bikeArrayList;
    }

    public static Bicicleta addBikeWithSetParemeters(ArrayList bikeList) {
        System.out.println("\n- This methods adds an entry to the array list with pre determined parameters");
        Bicicleta bicicleta1 = new Bicicleta("KGB", "Ultra", Bicicleta.BikeType.FLATLAND);
        bikeList.add(bicicleta1);
        System.out.println("New bike: " + bicicleta1 + "\n");
        return bicicleta1;


    }

    public static void recorrerLista(ArrayList<Bicicleta> bikeList) {
        System.out.println("This prints every item in the list");
        int listSize = bikeList.size();
        //System.out.println(listSize);
        for (int i = 0; i < listSize; i++) {
            System.out.println("Bike: " + i + " " + bikeList.get(i));
        }
    }


    public static void showBikeModel(ArrayList<Bicicleta> bikeList) {
        System.out.println("\nThis method checks for the model of a bike");
/*
        if (bikeList.isEmpty()) {
            System.out.println("The bike list is empty!");
            return;
        }*/

        int indexOfBikeToCheck = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter bike to check: ");
            try {
                indexOfBikeToCheck = Integer.parseInt(sc.nextLine());
                if (indexOfBikeToCheck >= 0 && indexOfBikeToCheck < bikeList.size()) {
                    validInput = true;
                } else {
                    System.out.println("There is no bike with that index\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.println("Bike model: " + bikeList.get(indexOfBikeToCheck).getModel());
    }

    //-
    private static BikeType getBikeTypeFromUser() {
        BikeType[] bikeTypes = BikeType.values();
        BikeType selectedBikeType = null;

        while (selectedBikeType == null) {

            System.out.println("Available bike types:");
            for (int i = 0; i < bikeTypes.length; i++) {
                System.out.println((i + 1) + ": " + bikeTypes[i]);
            }
            System.out.print("Select a bike type (1-" + bikeTypes.length + "): ");

            try {
                int selection = Integer.parseInt(sc.nextLine());

                if (selection >= 1 && selection <= bikeTypes.length) {
                    selectedBikeType = bikeTypes[selection - 1];
                } else {
                    System.out.println("Invalid selection. Please enter a number between 1 and " + bikeTypes.length);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Must be a number.");
            }
        }

        return selectedBikeType;
    }


    public static void addBike(ArrayList<Bicicleta> bikeList) {

        System.out.println("- This method lets you manually add bikes to the list");
        System.out.println(" How many bikes do you want to add? ");

        boolean validNumberOfBikes = false;
        int numberBikesToAdd = 0;

        while (!validNumberOfBikes) {
            try {
                numberBikesToAdd = Integer.parseInt(sc.nextLine());
                if (numberBikesToAdd > 0) {
                    validNumberOfBikes = true;
                } else {
                    System.out.println("Number must be positive");
                }

            } catch (NumberFormatException numberFormatException) {
                System.out.println("The number of bikes must be an int");
            }
        }
        //System.out.println("exiting loop"); // debug
        for (int i = 0; i < numberBikesToAdd; i++) {
            //System.out.println("debug " +i);
            System.out.println("Bike: " + i);

            System.out.print("Please enter make: ");
            String make = sc.nextLine();

            System.out.println("Please enter model: ");
            String model = sc.nextLine();

            System.out.println("Please enter bike type");
            BikeType bikeType = getBikeTypeFromUser();

            Bicicleta newBike = new Bicicleta(make, model, bikeType);
            bikeList.add(newBike);

            System.out.println("Bike added! : " + newBike + "\n");

            //System.out.println(bikeList);// debug shows entry is added, but unformatted

        }


    }

}



