import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // Para probar el tiempo de ejecución de los distintos métodos de ordenamiento y búsqueda, se utiliza System.currentTimeMillis()
        // Los archivos games100, games10000 y games 1000000 fueron generados gracias a la clase GenerateData y están almacenados en la dirección
        // src/benchmark_batches.

        long startTime = System.currentTimeMillis();

        // Se crean las listas de 100, 10000 y 1000000 de objetos respectivamente utilizando la función readGamesFromCSV de la clase GenerateData.
        GenerateData generateData = new GenerateData();
        ArrayList<Game> games100 = generateData.readGamesFromCSV("src/benchmark_batches/games_100.csv");
        ArrayList<Game> games10000 = generateData.readGamesFromCSV("src/benchmark_batches/games_10000.csv");
        ArrayList<Game> games1000000 = generateData.readGamesFromCSV("src/benchmark_batches/games_1000000.csv");

        Dataset dataset1 = new Dataset(games100);
        Dataset dataset2 = new Dataset(games10000);
        Dataset dataset3 = new Dataset(games1000000); // Inicialización de un Dataset con una lista de 1000000 de objetos de tipo Game.

        long sortingStartTime = System.currentTimeMillis();

        dataset3.sortByAlgorithm("", "price"); // Al no haber ningún algoritmo en el primer parámetro, se ordena con Collections.sort() usando el atributo price.

        long sortingEndTime = System.currentTimeMillis();

        long sortingTime = sortingEndTime - sortingStartTime;

        // Para probar los algoritmos de búsqueda binaria se requiere tener el arreglo previamente ordenado, por lo que se mide el tiempo de
        // ejecución del algoritmo de ordenamiento y posterioremente se le resta al tiempo de ejecución del algoritmo de búsqueda a analizar, de
        // manera que se mida el tiempo que demora el algoritmo de búsqueda binaria sin tomar en cuenta el previo ordenamiento.
        System.out.println("Sorting time: " + sortingTime + " ms, sorted by: " + dataset3.getSortedByAttribute());

        ArrayList<Game> temp = dataset3.getGamesByPrice(10000);

        long endTime = System.currentTimeMillis();

        // Como se mencionó previamente, el tiempo de ejecución es el tiempo que tarda en ejecutarse el algoritmo de búsqueda menos el tiempo de ordenamiento
        System.out.println("Execution time: " + (endTime - startTime - sortingTime) + " ms");

    }

}
