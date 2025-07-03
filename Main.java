import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        System.out.println("Colección de bicicletas");

        ArrayList<Bicicleta> bikeList = Bicicleta.newBikeArray();

        // System.out.println(bikeList.get()); //debug shows newBikeArray is made

        Bicicleta.addBikeWithSetParemeters(bikeList);

        Bicicleta.addBike(bikeList);
        //Bicicleta.recorrerLista(bikeList);

        // recorrer
        Bicicleta.recorrerLista(bikeList);

        //propiedad de una bici:  model
        Bicicleta.showBikeModel(bikeList);


        System.out.println(bikeList); //updated list
        System.out.println("\n- Set make of the first bike to: We The People");
        System.out.println("Original bike: " + bikeList.get(0));
        bikeList.get(0).setMake("We The People");

        System.out.println("Updated entry: " + bikeList.get(0));


        System.out.println("\n - Use some random methods :)  \n");
        bikeList.get(1).bell();
        bikeList.get(1).derecha();

        System.out.println("ZZZzzzzZZzzzzz");


        //end of main
    }


}
