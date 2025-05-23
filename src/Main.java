import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Game> data = new ArrayList<>();

        data.add(new Game("g1", "c1", 5, 100));
        data.add(new Game("g2", "c2", 10, 40));
        data.add(new Game("g3", "c3", 13, 40));
        data.add(new Game("g4", "c4", 20, 12));
        data.add(new Game("g5", "c5", 21, 12));
        data.add(new Game("g6", "c6", 30, 12));
        data.add(new Game("g7", "c7", 31, 12));


        Dataset dataset = new Dataset(data);

        ArrayList<Game> gamesSorted = dataset.getGamesByPriceRange(13, 31);

        for(int i = 0; i < gamesSorted.size(); i++) {
            System.out.println(gamesSorted.get(i).getName());
        }
    }

}
