public class Dog {

    private static final double DACHSHUND_TAIL_LENGTH = 3.7;

    private String name;
    private double tailLength;
    private int age;
    private String breed;
    private int weight;
    private Owner owner;


    public Dog(String name, String breed, int age, int weight) {

        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;

    }

    public void setOwner(Owner specificOwner) {

        if (!hasOwner()) {
            if (specificOwner != owner) {
                owner = specificOwner;
                owner.addDogToOwner(this);
            }
        }

    }

    public void removeOwnerOfDog() {
        if (owner != null) {

            owner.removeDogFromOwner(this);
            owner = null;

        }
    }

    public boolean hasOwner() {

        return owner != null;
    }

    public Owner getOwner() {

        return owner;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public String getBreed() {

        return breed;
    }

    public int getWeight() {

        return weight;
    }

    public double getTailLength() {

        if (breed.equalsIgnoreCase("Dachshund") || breed.equalsIgnoreCase("Tax")) {
            return DACHSHUND_TAIL_LENGTH;
        }
        tailLength = ((double) age * weight) / 10;
        return tailLength;

    }

    public void increaseAge() {
        age++;
    }

    @Override
    public String toString() {


        if (hasOwner()) {
            return name + " " + age + " " + breed + " " + weight + " " + getTailLength() + " owned by " + owner.getName();

        } else return name + " " + age + " " + breed + " " + weight + " " + getTailLength();
    }
}

