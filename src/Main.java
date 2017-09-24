import com.shlak.DijkstraAlgorithm;
import com.shlak.Runners;
import com.shlak.StreetMap;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ClientSpeaker {
    private Map<Integer, String> menu = new HashMap<>();
    private int[] distancesCool;

    public int[] getDistancesCool() {
        return distancesCool;
    }

    public void setDistancesCool(int[] distancesCool) {
        this.distancesCool = distancesCool;
    }

    StreetMap obj = new StreetMap();


    private void fuller() {
        menu.put(1, "Neapolitano");
        menu.put(2, "Pepperoni");
        menu.put(3, "Philadelphia");
        menu.put(4, "Cecilia");
        menu.put(5, "4 Cheeses");
    }


    private String[] strings = {"\t\t\tМеню", "1.Неаполитана", "2.Пеперони", "3.Филаделфия", "4.Сецилия"
            , "5. 4 сыра", "Что? Пицца? Не з***й мемя!!! Выбери номер "};

    public void getStartToGetFood() throws FileNotFoundException {
        obj.adreser();// создаю объект для получения в этом файле полной инфы из класса

        fuller(); // заполняю меню

        propositor();// предложение позиций из меню
        int dd = addresser(obj.getStreetsNumbers());
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(obj.getArr().size(), obj.getDistances());
        distancesCool = dijkstraAlgorithm.dijkstra(obj.getStartPoint() - 1);// реализация Дейкстры
        curierDelivery(distancesCool[dd - 1]);

    }

    private void propositor() {
        for (String str : this.strings
                ) {
            System.out.println(str);
        }
        System.out.println("Вы выбрали " + menu.get(shortScanner()));

    }

    private int addresser(ArrayList arrayList) {

        System.out.println("Выберите улицу, на которую необходима доставка");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + 1 + ". " + arrayList.get(i));
        }
        int destinationDot = shortScanner();
        System.out.println("Вы выбрали " + arrayList.get(destinationDot - 1));
        return destinationDot;
    }

    private int shortScanner() {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        return p;
    }

    private void curierDelivery(int distance) {
        // while (obj.getCourierCount() != 0){
        Thread thread = new Thread(new Runners(distance));
        System.out.println("Курьер будет ехать к Вам " + distance * 5 + "минут");
        thread.start();
        //}
    }
}

    public class Main {
        public static void main(String[] args) throws FileNotFoundException {

            ClientSpeaker objer = new ClientSpeaker();
            objer.getStartToGetFood();
    }
}

