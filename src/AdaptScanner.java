import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;



public class AdaptScanner {

    private static ArrayList<InputStream> inputReader = new ArrayList<>();
    private Scanner scanner;

    public AdaptScanner (InputStream txt) {
        if(inputReader.contains(txt)) {
            throw new IllegalStateException("Error!");
        }
        this.scanner = new Scanner(txt);
        inputReader.add(txt);
    }
    public AdaptScanner(){

        this(System.in);
    }

    public String stringInput(String str){

        String text = "";

        do{

            System.out.print(str + "?>");
            text = scanner.nextLine();

            if(text.isBlank() || text.isEmpty()){
                System.out.println("Error! Name cannot be empty");
            }


        }while(text.isBlank() || text.isEmpty());

        return text.trim();
    }
    public int intInput(String str){
        System.out.print(str + "?>");
        int wholeNr = scanner.nextInt();
        scanner.nextLine();
        return wholeNr;
    }
    public double doubleInput(String str){
        System.out.print(str + "?>");
        double decimalNr = scanner.nextDouble();
        scanner.nextLine();
        return decimalNr;
    }
}