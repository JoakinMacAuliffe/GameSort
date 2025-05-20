import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        ArrayList<Game> data = new ArrayList<>();

        data.add(new Game("geometry dasgfhs", "gay", 10, 100));
        data.add(new Game("asdlfsa", "hola", 123, 40));

        Dataset dataset = new Dataset(data);

    }
}
