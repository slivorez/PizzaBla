import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\t\t\tМеню"+'\n'+"1.Неаполитана");

        StreetMap creater = new StreetMap();
        creater.adreser();
        Runners runners = new Runners();
        Thread runner = new Thread(runners);
        runner.run();
    }
}