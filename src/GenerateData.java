import java.util.ArrayList;
import java.util.Random;

public class GenerateData {

    private String[] words = {"Dragon", "Empire", "Quest", "Galaxy","Fant", "Legends", "Warrior",
    "Pergio","Tourbes", "Do", "While", "Ohliver", "Sinto", "Super", "Ovalous"};
    private String[] categories = {"Accion", "Aventura", "Estrategia", "RPG", "Deportes", "Simulacion", ""};
    private Random random = new Random();

    public ArrayList<Game> generateData(int n) {
        ArrayList<Game> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String randomName = words[random.nextInt(words.length)] + words[random.nextInt(words.length)];
            String randomCategory = categories[random.nextInt(categories.length)];
            int randomPrice = random.nextInt(70000 - 1000 + 1) + 1000;
            int randomQuality = random.nextInt(101);
            arrayList.add(new Game(randomName, randomCategory, randomPrice, randomQuality));
        }
        return arrayList;
    }

}
