import java.util.*;


public class DogRegister {

    private ArrayList<Owner> ownerList = new ArrayList<>();

    private ArrayList<Dog> listOfDogs = new ArrayList<>();

    private AdaptScanner adaptscanner = new AdaptScanner();

    private String command;

    private void prepProgram() {
        System.out.println(
                "Commmands: " +
                        "\nregister new dog " + "\nlist dogs " +
                        "\nincrease age " + "\nremove dog " +
                        "\nregister new owner " + "\ngive dog " +
                        "\nlist owners " + "\nremove owned dog " +
                        "\nremove owner " + "\nexit");
    }

    private void startup() {

        prepProgram();

        do {

            command = adaptscanner.stringInput("Command").trim().toLowerCase();

            runCommandLoop(command);

        } while (!command.equalsIgnoreCase("exit"));
    }

    private void runCommandLoop(String str) {

        switch (str) {
            case "register new dog":
                addDogToList();
                break;
            case "list dogs":
                sortDogs();
                showTailLength();
                break;
            case "increase age":
                ageIncrease();
                break;
            case "remove dog":
                removeDog();
                break;
            case "register new owner":
                addOwnerToList();
                break;
            case "give dog":
                giveDogToOwner();
                break;
            case "list owners":
                listOwners();
                break;
            case "remove owned dog":
                removeDogFromOwner();
                break;
            case "remove owner":
                removeOwnerFromDog();
                break;
            case "exit":
                System.out.println("Welcome back!");
                break;
            default:
                System.out.println("Error: there is no such command, try again.");
                startup();
                break;
        }
    }

    public static void main(String[] args) {

        DogRegister dogRegister = new DogRegister();
        dogRegister.startup();
    }

    private void addDogToList() {

        listOfDogs.add(registerDog());

    }

    private Dog registerDog() {

        String name = adaptscanner.stringInput("Name");

        String breed = adaptscanner.stringInput("Breed");

        int age = adaptscanner.intInput("Age");

        int weight = adaptscanner.intInput("Weight");

        return new Dog(name, breed, age, weight);

    }

    private void showTailLength() {

        if (listOfDogs.isEmpty()) {
            System.out.println("Error: no dogs in register");
        } else {

            double tailLength = adaptscanner.doubleInput("Smallest tail length to display");

            System.out.println("The following dogs has such a large tail:");

            fetchTailLength(tailLength);

        }
    }

    private void fetchTailLength(double tailLength) {

        boolean dogExists = false;

        for (int i = 0; i < listOfDogs.size(); i++) {

            if (listOfDogs.get(i) == null && tailLength <= listOfDogs.get(i).getTailLength()) {
                System.out.println(listOfDogs.get(i));
                dogExists = true;
            } else if (tailLength <= listOfDogs.get(i).getTailLength()) {
                System.out.println(listOfDogs.get(i));
                dogExists = true;

            }
        }
        if (!dogExists) {
            System.out.println("Error: no dog has a tail that long");
        }

    }

    private void swapDogs(int firstIndex, int secondIndex) {
        Dog tempDog = listOfDogs.get(firstIndex);
        Dog secondDog = listOfDogs.get(secondIndex);
        listOfDogs.set(firstIndex, secondDog);
        listOfDogs.set(secondIndex, tempDog);
    }

    private void collectionSwap(int a, int b) {
        Collections.swap(listOfDogs, a, b);
    }

    private boolean compareDogs(int indexOne, int indexTwo) {


        double tailone = listOfDogs.get(indexOne).getTailLength();
        double tailtwo = listOfDogs.get(indexTwo).getTailLength();


        if (tailone > tailtwo) {
            return false;
        } else if (tailone == tailtwo) {
            String nameone = listOfDogs.get(indexOne).getName().trim();
            String nametwo = listOfDogs.get(indexTwo).getName().trim();
            int compare = nameone.compareTo(nametwo);
            if (compare > 0) {


                return false;
            }

        }
        return true;
    }

    private int locateSmallestDogIndex(int index) {

        int minIndex = index;

        for (int i = index; i < listOfDogs.size(); i++) {
            if (compareDogs(i, minIndex)) {
                minIndex = i;
            }

        }
        return minIndex;
    }

    private void sortDogs() {

        for (int i = 0; i < listOfDogs.size() - 1; i++) {

            int index = locateSmallestDogIndex(i);

            if(index != i){

                collectionSwap(i, locateSmallestDogIndex(i));

            }

        }

    }

//    private int sortDogs() {
//
//        int swaps = 0;
//
//        if (listOfDogs.size() == 0) {
//            return 0;
//        }
//
//        for (int i = 0; i < listOfDogs.size() - 1; i++) {
//
//            collectionSwap(i, locateSmallestDogIndex(i));
//
//            swaps++;
//        }
//        return swaps;
//    }

    private void giveDogToOwner() {

        String nameDog = adaptscanner.stringInput("Enter the name of the dog");

        if (checkIfDogExist(nameDog)) {

            Dog dog = getDogName(nameDog);

            if(dog.hasOwner()){

                System.out.println("Error: the dog already has an owner");
                return;
            }

            String nameOwner = adaptscanner.stringInput("Enter the name of the new owner");

            if (checkIfOwnerExist(nameOwner)) {

                Owner owner = getOwnerName(nameOwner);

                if (!owner.ownsDog(dog)) {

                    dog.setOwner(owner);

                    System.out.println(owner.getName() + " now owns " + dog.getName());

                }

            }else{
                System.out.println("Error: no such owner");
            }
        }else{
            System.out.println("Error: no dog with that name");
        }

    }

    private boolean checkIfDogExist(String name) {

        for (Dog dog : listOfDogs) {

            if (dog == getDogName(name)) {
                return true;

            }
        }
        return false;
    }

    private boolean checkIfOwnerExist(String name) {
        for (Owner owner : ownerList) {


            if (owner.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private Dog getDogName(String name) {

        for (Dog dog : listOfDogs) {
            if (dog.getName().equalsIgnoreCase(name)) {
                return dog;
            }
        }
        return null;
    }

    private Owner getOwnerName(String name) {
        for (Owner owner : ownerList) {
            if (owner.getName().equalsIgnoreCase(name)) {


                return owner;
            }
        }
        return null;
    }

    private void listOwners() {

        if (ownerList.isEmpty()) {
            System.out.println("Error: no owners in register");
            return;
        }

        for (Owner owner : ownerList) {

            System.out.println(owner);
        }
    }

    private void ageIncrease() {

        String name = adaptscanner.stringInput("Enter the name of the dog");

        Dog dog = getDogName(name);

        if (dog != null) {

            dog.increaseAge();

            System.out.println(dog.getName() + " is now one year older");

            return;
        }
        System.out.println("Error: no such dog");

    }

    private void removeDog() {

        String name = adaptscanner.stringInput("Enter the name of the dog");

        Dog dog = getDogName(name);

        if (dog != null) {

            listOfDogs.remove(dog);

            System.out.println(dog.getName() + " is removed from the register");

            return;
        }
        System.out.println("Error: no such dog");

    }

    private void addOwnerToList() {

        ownerList.add(registerOwner());

    }

    private Owner registerOwner() {

        String name = adaptscanner.stringInput("Name");

        return new Owner(name);

    }

    private void removeDogFromOwner() {

        String disownedDog = adaptscanner.stringInput("Enter the name of the dog").trim();

        Dog dog = getDogName(disownedDog);

        if (listOfDogs.contains(dog)) {

            if (dog.hasOwner()) {

                dog.getOwner().removeDogFromOwner(dog);

                dog.removeOwnerOfDog();

                System.out.println(dog.getName().trim() + " is removed ");

            } else {
                System.out.println("Error: " + dog.getName().trim() + " is not owned by anyone");
            }
        } else {
            System.out.println("Error: no such dog");
        }

    }

    private void removeOwnerFromDog() {

        String nameOfOwner = adaptscanner.stringInput("Enter the name of the user").trim();

        Owner owner = getOwnerName(nameOfOwner);

        if (ownerList.contains(owner)) {

            removeDogFromList(owner);

            ownerList.remove(owner);

            System.out.println(owner.getName().trim() + " is removed from the register");

        } else {
            System.out.println("Error: no such owner");
        }
    }

    private void removeDogFromList(Owner owner) {

        ArrayList<Dog> tempDogArrayList = new ArrayList<Dog>();

        for (Dog dog : listOfDogs) {

            if (dog.getOwner() != owner) {

                tempDogArrayList.add(dog);

            }
        }
        listOfDogs = tempDogArrayList;
    }

}