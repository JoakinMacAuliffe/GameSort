import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GenerateData generateData = new GenerateData();
        ArrayList<Game> data1 = generateData.generateData(100);

        Dataset dataset = new Dataset(data1);

        ArrayList<Game> data = dataset.getData();

        dataset.sortByAlgorithm("insertionsort", "price");

        for(int i = 0; i < data.size(); i++) {
            System.out.println(i+": " + "$" + data.get(i).getPrice() + ", " + data.get(i).getCategory() + ", " + data.get(i).getQuality());
        }

        ArrayList<Game> data2 = dataset.getGamesByQuality(30);

//        for(int i = 0; i < data2.size(); i++) {
//            System.out.println(data2.get(i).getQuality());
//        }

    }

}
