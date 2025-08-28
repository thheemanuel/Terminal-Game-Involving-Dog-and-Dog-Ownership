import java.util.ArrayList;

public class AssignmentEightPointFour {

        private ArrayList<Owner> ownerList = new ArrayList<>();
        private ArrayList<Dog> dogList = new ArrayList<>();

        private AdaptScanner adaptscanner = new AdaptScanner();


        public void giveDogToOwner(){ //metod som lägger till en hund till en ägare

            String nameDog = adaptscanner.stringInput("Enter the name of the dog"); //frågar om namnet på hunden

            if(checkIfDogExists(nameDog)){ //if-sats som kollar om hunden finns för att fortsätta metoden

                String nameOwner = adaptscanner.stringInput("Enter the name of the new owner"); //frågar om namnet på ägaren

                if (checkIfOwnerExists(nameOwner,nameDog)) { //kollar om både namnet på hund och ägare finns

                    Dog dog = getDogName(nameDog); //ersätter hund som finns i en angiven position

                    Owner owner = getOwnerName(nameOwner); //ersätter ägare som finns i en angiven position

                    if (!owner.getDogArray().hasDog(dog)){ //kollar om ägare inte finns i listan

                        dog.setOwner(owner);

                        System.out.println(owner.getName() + " now owns " + dog.getName()); //skriver ut att ägaren nu äger hunden
                    }
                }
            }
        }

        public boolean checkIfDogExists(String name){ //metod som kollar så hund har ägare och namn

            if(!name.isEmpty()) {
                if(doesDogExist(name)){
                    //kollar om hunden existerar
                    if(!getDogName(name).hasOwner()){ //kollar om hund har ägare
                        return true; //returnerar om hund har ägare
                    }else { System.out.println("Error: the dog already has an owner"); } //skriver ut att hund redan har ägare
                }else { System.out.println("Error: no dog with that name");  } //skriver ut att det inte finns hund med det inmatade namnet
            }else{System.out.println("Error: the name can't be empty");} //skriver ut att hunden måste ha ett namn

            //default
            return false; //returnerar metoden
        }
        public boolean checkIfOwnerExists(String name, String dogName){

            if(!name.isEmpty()) {



                if(doesOwnerExist(name)){ //kollar om ägare existerar
                    Dog dogOne = getDogName(dogName);
                    Owner owner = getOwnerName(name);


                    if(!owner.getDogArray().hasDog(dogOne)){

                        return true; //returnerar om ägare inte är med i listan
                    }
                }else { System.out.println("Error: no such owner");  } //skriver ut att ägare inte finns



            }else{System.out.println("Error: the name can't be empty");} //skriver ut att ägare måste ha namn

            //default
            return false; //om ägare har namn och är med i listan
        }


        public boolean doesDogExist(String name){ //metod som kollar om hund finns


            for (Dog dog: dogList){ //loopar genom hundar



                if (dog==getDogName(name)) { //kollar så att hund finns
                    return true; //returnerar om hund finns


                }
            }
            return false; //returnerar om hund inte finns
        }

        public boolean doesOwnerExist(String name){ //metod som kollar om ägare finns
            for (Owner owner: ownerList){ //loopar genom ägare


                if (owner.getName().equalsIgnoreCase(name)) { //kollar så att ägare finns
                    return true; //returnerar om ägare finns
                }
            }
            return false; //returnerar om ägare inte finns
        }

        public Dog getDogName(String name){ //metod som får fram hund genom namn



            for (Dog dog : dogList){ //loopar genom hundar
                if(dog.getName().equalsIgnoreCase(name)){
                    return dog; //returnerar hund
                }
            }
            return null; //returnerar inget
        }
        public Owner getOwnerName(String name){ //metod som får fram ägare genom namn
            for (Owner owner : ownerList){ //loopar genom ägare
                if(owner.getName().equalsIgnoreCase(name)){


                    return owner; //returnerar ägare
                }
            }
            return null; //returnera inget
        }

        public void listOwners(){

            if(ownerList.isEmpty()){
                System.out.println("Error: no owners in register");
                return;
            }

            for (Owner owner : ownerList){

                System.out.println(owner);





            }

        }

        public void showTailLength() {

        if (dogList.isEmpty()) {
            System.out.println("Error: no dogs in register");
        } else{

            double tailLength = adaptscanner.doubleInput("Smallest tail length to display");

            System.out.println("The following dogs has such a large tail:");

            fetchTailLength(tailLength);

        }
    }


     private void fetchTailLength(double tailLength) {

        boolean dogExists = false;

        for (int i = 0; i < dogList.size(); i++) {

            if(dogList.get(i) == null && tailLength <= dogList.get(i).getTailLength()){
                System.out.println(dogList.get(i));
                dogExists = true;
            }

            else if(tailLength <= dogList.get(i).getTailLength()){
                System.out.println(dogList.get(i));
                dogExists = true;

            }







        }
        if(!dogExists){

            System.out.println("Error: no dog has a tail that long");

        }

    }
}







