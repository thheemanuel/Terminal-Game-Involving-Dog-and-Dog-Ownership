//6.2
public class DogmKom { //själva hundklassen

    private static final double SPECIFICLENGTH_FOR_DACHSHUND = 3.7; //specifik svanslängd för tax

    private String name; //hundens namn
    private double tailLength; //hundens svanslängd
    private int age; //hundens ålder
    private String breed; //hundens ras
    private int weight; //hundens vikt


    public DogmKom(String name, String breed, int age, int weight){

        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }


    public String getName() { //metod som kallar på hundens namn
        return name; //får fram hundens namn efter metoden kallat på den
    }

    public int getAge() { //metod som kallar på hundens ålder
        return age; //får fram hundens ålder efter metoden kallat på den
    }

    public String getBreed() { //metod som kallar på hundens ras
        return breed; //får fram hundens ras efter metoden kallat på den
    }

    public int getWeight() { //metod som kallar på hundens vikt
        return weight; //får fram hundens vikt efter metoden kallat på den
    }

    public double getTailLength(){ //metod som får fram svanslängden på hunden

        if (breed.equalsIgnoreCase("Dachshund") || breed.equalsIgnoreCase("Tax")) {
            return SPECIFICLENGTH_FOR_DACHSHUND; //om hunden är en tax har den förbestämd svanlängd
        }
        tailLength = ((double) age*weight)/10; //annars räknar denna formel hundens svanslängd
        return tailLength; //returnerar den beräknade svanslängden

    }
    //hela nedanstående metod gör så hundarna kan öka i ålder men inte minska pga logik
    public void increaseAge(int number) {
        int oldAge = this.age;

        this.age = age + number;

        if (oldAge > this.age) {
            this.age = oldAge;        }
    }


    @Override //gör så nedanstående del åsidosätts som en superklass
    public String toString() { //metod som skriver ut all information om hunden
        return "Dog{" +
                "name='" + name + '\'' +                //returnerar hundens namn
                ", age=" + age +                        //returnerar hundens ålder
                ", breed='" + breed + '\'' +            //returnerar hundens ras
                ", weight=" + weight + '\'' +           //returnerar hundens vikt
                ", tail length=" + getTailLength() +    //returnerar hundens svanslängd
                '}';
    }

}

