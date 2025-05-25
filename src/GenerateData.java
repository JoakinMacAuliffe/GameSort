import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GenerateData {

    private String[] words = {"Dragon", "Empire", "Quest", "Galaxy","Fant", "Legends", "Warrior",
    "Pergio","Tourbes", "Do", "While", "Ohliver", "Sinto", "Super", "Ovalous"};
    private String[] categories = {"Accion", "Aventura", "Estrategia", "RPG", "Deportes", "Simulacion"};
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

    public void saveGamesToCSV(ArrayList<Game> games, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("name,category,price,quality");
            for (Game game : games) {
                writer.printf("\"%s\",\"%s\",%d,%d%n",
                        game.getName().replace("\"", "\"\""),
                        game.getCategory().replace("\"", "\"\""),
                        game.getPrice(),
                        game.getQuality());
            }
        }
    }

    public ArrayList<Game> readGamesFromCSV(String filename) throws IOException {
        ArrayList<Game> games = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String category = parts[1];
                    int price = Integer.parseInt(parts[2]);
                    int quality = Integer.parseInt(parts[3]);
                    games.add(new Game(name, category, price, quality));
                }
            }
        }
        return games;
    }

}
