import java.util.Arrays;

public class DogList {
    private Dog[] dogs = new Dog[0];

    public boolean hasDog(Dog dog) {
        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i].equals(dog)) {
                return true;
            }
        }
        return false;
    }

    public void addDog(Dog dog) {
        if (dog == null || hasDog(dog)) {
            return;
        }
        Dog[] temp = new Dog[dogs.length + 1];
        for (int i = 0; i < dogs.length; i++) {
            temp[i] = dogs[i];
        }
        temp[temp.length - 1] = dog;
        dogs = temp;
    }

    public void discardDog(Dog dog) {

        if (!hasDog(dog)) {
            return;
        }

        Dog[] temp = new Dog[dogs.length - 1];

        for (int i = 0, k = 0; i < dogs.length; i++) {
            if (dogs[i] != dog) {
                temp[k++] = dogs[i];
            }
        }
        dogs = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(dogs);
    }
}
