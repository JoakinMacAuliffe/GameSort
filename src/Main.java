import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Game> data = new ArrayList<>();

        data.add(new Game("geometry dasgfhs", "test", 123, 100));
        data.add(new Game("asdlfsa", "hola", 10, 40));
        data.add(new Game("hola", "cat1", 123, 40));
        data.add(new Game("test", "cat2", 20, 12));

        Dataset dataset = new Dataset(data);

        ArrayList<Game> gamesSorted = dataset.getGamesByPrice(123);

        for(int i = 0; i < gamesSorted.size(); i++) {
            System.out.println(gamesSorted.get(i).getName());
        }
    }

}
