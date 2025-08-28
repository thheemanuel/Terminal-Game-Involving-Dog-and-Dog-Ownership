import java.util.ArrayList;

public class AssignmentEightPointEight {
    private ArrayList<Dog> dogList = new ArrayList<>();
    private AdaptScanner adaptscanner = new AdaptScanner();


    public void removeDog() {


        String name = adaptscanner.stringInput("Enter the name of the dog").trim();

        Dog dog = showDog(name);



        if(dog != null){

            if(dog.hasOwner()){


                dog.getOwner().removeDogFromOwner(dog);

            }

            dogList.remove(dog);

            System.out.println(dog.getName().trim() + "is removed from the register");

            return;


        }

        System.out.println("Error: no such dog");


    }
    private Dog showDog(String name){

        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)){
                return dog;
            }
        }
        return null;



    }

}





