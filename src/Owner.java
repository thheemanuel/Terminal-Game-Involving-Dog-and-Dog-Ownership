public class Owner {
    private String name;
    private DogList dogs = new DogList();

    public Owner(String name) {

        this.name = name;
    }
    public void addDogToOwner(Dog dog) {

        if (dog != null) {
            dogs.addDog(dog);

            dog.setOwner(this);
        }
    }
    public boolean ownsDog(Dog dog) {

        if (dogs.hasDog(dog)) {
            return true;
        }
        return false;
    }
    public void removeDogFromOwner(Dog dog) {

        if (dog != null) {

            if (ownsDog(dog)) {

                dogs.discardDog(dog);

                dog.removeOwnerOfDog();
            }
        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return name + " " + dogs;

    }
}
