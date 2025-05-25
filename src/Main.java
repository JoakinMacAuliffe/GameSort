import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GenerateData generateData = new GenerateData();
        ArrayList<Game> data1 = generateData.generateData(100);

        Dataset dataset = new Dataset(data1);

        ArrayList<Game> data = dataset.getData();

        dataset.sortByAlgorithm("asdfa", "quality");

        for(int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).getQuality());
        }

        ArrayList<Game> data2 = dataset.getGamesByPrice(10000);

//        for(int i = 0; i < data2.size(); i++) {
//            System.out.println(data2.get(i).getPrice());
//        }

    }

}
