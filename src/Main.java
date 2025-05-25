import java.awt.font.GlyphMetrics;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GenerateData generateData = new GenerateData();
        ArrayList<Game> data1 = generateData.generateData(1000);

        Dataset dataset = new Dataset(data1);

        ArrayList<Game> data = dataset.getData();

        dataset.sortByAlgorithm("bubblesort", "price");

//        for(int i = 0; i < data.size(); i++) {
//            System.out.println(i+": " + "$" + data.get(i).getPrice() + ", " + data.get(i).getCategory() + ", " + data.get(i).getQuality());
//        }

        ArrayList<Game> data2 = dataset.getGamesByPriceRange(3000, 10000);

        for(int i = 0; i < data2.size(); i++) {
            System.out.println(i+": " + "$" + data2.get(i).getPrice() + ", " + data2.get(i).getCategory() + ", " + data2.get(i).getQuality());
        }

    }

}
