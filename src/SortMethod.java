import java.util.ArrayList;
import java.util.Collections;

public class SortMethod {

    private ArrayList<Dog> dogList = new ArrayList<>();

    private void swapDogs(int indexA, int indexB){
        Dog tempDog = dogList.get(indexA);
        Dog secondDog = dogList.get(indexB);
        dogList.set(indexA, secondDog);
        dogList.set(indexB, tempDog);
    }


    private void collectionSwap(int a, int b){

        Collections.swap(dogList, a, b);
    }


    private boolean compareDogs(int indexOne, int indexTwo) { //metod som jämför två hundar för att kunna sortera listan
        //returnerar det index med kortast svans

        double tail1 = dogList.get(indexOne).getTailLength(); //får fram svanslängden på hund 1

        double tail2 = dogList.get(indexTwo).getTailLength(); //får fram svanslängden på hund 2

        if(tail1 > tail2){
            return false;
        } //jämför svanslängden
        else if (tail1 == tail2) { //kollar om svanslängden är samma på båda hundarna

            String name1 = dogList.get(indexOne).getName().trim(); //får fram namnet på hund 1

            String name2 = dogList.get(indexTwo).getName().trim(); //får fram namnet på hund 2

            int checkName = name1.compareTo(name2); //jämför hundarnas namn

            if (checkName > 0 ) {

                //1 after 2
                return false;
            }
        }
        return true;
    }


    private int locateSmallestDogIndex(int index) {

        int minIndex = index;

        for (int i = index; i < dogList.size(); i++) {
            if(compareDogs(i, minIndex)){
                minIndex = i;
            }
        }
        return minIndex;
    }


    public int sortDogs(){

        int numberOfSwaps = 0;
        
        if(dogList.size() == 0){

            return 0;
        }

        for (int i=0; i < dogList.size()-1; i++) {

            if(!compareDogs(i, locateSmallestDogIndex(i))){

                collectionSwap(i, locateSmallestDogIndex(i));

                numberOfSwaps++;
            }
        }
        return numberOfSwaps;
    }

}
