import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GenerateData generateData = new GenerateData();
        ArrayList<Game> data1 = generateData.generateData(100);

        Dataset dataset = new Dataset(data1);

        dataset.sortByAlgorithm("bubblesort", "price");

        ArrayList<Game> gamesByPriceRange = dataset.getGamesByPriceRange(3000, 50000);

        for(int i = 0; i < gamesByPriceRange.size(); i++) {
            System.out.println(gamesByPriceRange.get(i).getPrice());
        }
    }

}
