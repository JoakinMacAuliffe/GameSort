import java.util.*;

public class Dataset {

	private ArrayList<Game> data;
	private String sortedByAttribute = "";

	SearchAndSortMethods searchAndSortMethods = new SearchAndSortMethods();

	Dataset(ArrayList<Game> data) {
		this.data = data;
	}

	public ArrayList<Game> getGamesByPrice(int price) {

		ArrayList<Game> dataByPrice = new ArrayList<>();

		if (sortedByAttribute.equalsIgnoreCase("price")) { // El atributo equivale a price ignorando mayúsculas

			int index = searchAndSortMethods.binarySearch(data, "price", 0, price, null, 0); // El índice se posiciona sobre el primer juego que coincida con el precio
			if (index == -1) return dataByPrice; // No existe ningún juego con ese precio, retorna lista vacía

			dataByPrice.add(data.get(index));

			int left = index - 1;
			while (left >= 0 && data.get(left).getPrice() == price) {
				dataByPrice.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while (right < data.size() && data.get(right).getPrice() == price) {
				dataByPrice.add(data.get(right));
				right++;
			}

			searchAndSortMethods.bubbleSort(dataByPrice, "price");

			return dataByPrice;
		} else {
			for (int i = 0; i < data.size(); i++) { // Busqueda lineal
				if (data.get(i).getPrice() == price) {
					dataByPrice.add(data.get(i));
				}
			}
			searchAndSortMethods.bubbleSort(dataByPrice, "price");
			return dataByPrice;
		}
	}

	public ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice) {
		ArrayList<Game> dataByPriceRange = new ArrayList<>();
		if (sortedByAttribute.equalsIgnoreCase("price")) {

			int index = searchAndSortMethods.binarySearch(data, "pricebyrange", lowerPrice, higherPrice, null, 0);
			if (index == -1) return dataByPriceRange;

			dataByPriceRange.add(data.get(index));

			int left = index - 1;
			while (left >= 0 && data.get(left).getPrice() >= lowerPrice
					&& data.get(left).getPrice() <= higherPrice) {
				dataByPriceRange.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while (right < data.size() && data.get(right).getPrice() <= higherPrice
					&& data.get(right).getPrice() >= lowerPrice) {
				dataByPriceRange.add(data.get(right));
				right++;
			}

			searchAndSortMethods.bubbleSort(dataByPriceRange, "price"); // Retornar arreglo dinámico ordenado en precio ascendente

			return dataByPriceRange;

		} else {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getPrice() >= lowerPrice
						&& data.get(i).getPrice() <= higherPrice) {
					dataByPriceRange.add(data.get(i));
				}
			}
			searchAndSortMethods.bubbleSort(dataByPriceRange, "price");
			return dataByPriceRange;
		}
	}

	public ArrayList<Game> getGamesByCategory(String category) {

		ArrayList<Game> dataSortedByCategory = new ArrayList<>();

		if (sortedByAttribute.equalsIgnoreCase("category")) {

			int index = searchAndSortMethods.binarySearch(data, "category", 0, 0, category, 0);
			if (index == -1) return dataSortedByCategory;
			dataSortedByCategory.add(data.get(index));

			int left = index - 1;
			while (left >= 0 && data.get(left).getCategory().compareTo(category) == 0) {
				dataSortedByCategory.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while (right < data.size() && data.get(right).getCategory().compareTo(category) == 0) {
				dataSortedByCategory.add(data.get(right));
				right++;
			}

			return dataSortedByCategory;

		} else {

			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getCategory().compareTo(category) == 0) dataSortedByCategory.add(data.get(i));
			}
		}
		return dataSortedByCategory;
	}

	public ArrayList<Game> getGamesByQuality(int quality) {
		ArrayList<Game> dataSortedByQuality = new ArrayList<>();

		if (sortedByAttribute.equalsIgnoreCase("quality")) {

			int index = searchAndSortMethods.binarySearch(data, "quality", 0, 0, null, quality);
			if (index == -1) return dataSortedByQuality;

			dataSortedByQuality.add(data.get(index));

			int left = index - 1;

			while (left >= 0 && data.get(left).getQuality() == quality) {
				dataSortedByQuality.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while (right < data.size() && data.get(right).getQuality() == quality) {
				dataSortedByQuality.add(data.get(right));
				right++;
			}

			return dataSortedByQuality;

		} else {

			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getQuality() == quality) {
					dataSortedByQuality.add(data.get(i));
				}
			}
			return dataSortedByQuality;
		}

	}

	public void sortByAlgorithm(String algorithm, String attribute) {
		this.sortedByAttribute = attribute.toLowerCase(); // Cambiar atributo sortedByAtributte al atributo ingresado a la función, de tal manera de que contenga el atributo correcto
		switch (algorithm.toLowerCase()) { // el string algorithm se convierte a minúsculas de tal manera de que no afecten las mayúsculas en el switch

			case "bubblesort":
				searchAndSortMethods.bubbleSort(data, attribute);
				break;

			case "insertionsort":
				searchAndSortMethods.insertionSort(data, attribute);
				break;

			case "selectionsort":
				searchAndSortMethods.selectionSort(data, attribute);
				break;

			case "mergesort":
				searchAndSortMethods.mergeSort(data, attribute);
				break;

			case "quicksort":
				searchAndSortMethods.quickSort(data, attribute);
				break;

			case "countingsort":
				searchAndSortMethods.countingSort(data, attribute);
				break;

			default:
				switch(attribute.toLowerCase()) {
					case "category":
						Collections.sort(data, new Comparator<Game>() {
							@Override
							public int compare(Game game1, Game game2) {
								return game1.getCategory().compareTo(game2.getCategory());
							}
						});
						break;
					case "quality":
						Collections.sort(data, new Comparator<Game>() {
							@Override
							public int compare(Game game1, Game game2) {
								return Integer.compare(game1.getQuality(), game2.getQuality());
							}
						});
						break;
					case "price":
					default:
						Collections.sort(data, new Comparator<Game>() {
							@Override
							public int compare(Game game1, Game game2) {
								return Integer.compare(game1.getPrice(), game2.getPrice());
							}
						});
						break;
				}
		}
	}

	public static void main(String[] args) {

		ArrayList<Game> games = new ArrayList<>();
		games.add(new Game("GameA", "RPG", 5000, 80));
		games.add(new Game("GameB", "Accion", 3000, 90));
		games.add(new Game("GameC", "RPG", 5000, 70));
		games.add(new Game("GameD", "Aventura", 7000, 80));

		Dataset dataset = new Dataset(games);

		// Pruebas bubbleSort

		dataset.sortByAlgorithm("bubbleSort", "price");
		System.out.println("Ordenado por precio usando bubbleSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getPrice());
		}

		dataset.sortByAlgorithm("bubbleSort", "quality");
		System.out.println("Ordenado por quality usando bubbleSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		dataset.sortByAlgorithm("bubbleSort", "category");
		System.out.println("Ordenado por category usando bubbleSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getCategory());
		}

		// Pruebas insertionSort

		dataset.sortByAlgorithm("insertionSort", "price");
		System.out.println("Ordenado por precio usando insertionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getPrice());
		}

		dataset.sortByAlgorithm("insertionSort", "quality");
		System.out.println("Ordenado por quality usando insertionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		dataset.sortByAlgorithm("insertionSort", "category");
		System.out.println("Ordenado por category usando insertionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getCategory());
		}

		// Pruebas selectionSort

		dataset.sortByAlgorithm("selectionSort", "price");
		System.out.println("Ordenado por precio usando selectionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getPrice());
		}

		dataset.sortByAlgorithm("selectionSort", "quality");
		System.out.println("Ordenado por quality usando selectionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		dataset.sortByAlgorithm("selectionSort", "category");
		System.out.println("Ordenado por category usando selectionSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getCategory());
		}

		// Pruebas mergeSort

		dataset.sortByAlgorithm("mergeSort", "price");
		System.out.println("Ordenado por precio usando mergeSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getPrice());
		}

		dataset.sortByAlgorithm("mergeSort", "quality");
		System.out.println("Ordenado por quality usando mergeSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		dataset.sortByAlgorithm("mergeSort", "category");
		System.out.println("Ordenado por category usando mergeSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getCategory());
		}

		// Pruebas quickSort

		dataset.sortByAlgorithm("quickSort", "price");
		System.out.println("Ordenado por precio usando quickSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getPrice());
		}

		dataset.sortByAlgorithm("quickSort", "quality");
		System.out.println("Ordenado por quality usando quickSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		dataset.sortByAlgorithm("quickSort", "category");
		System.out.println("Ordenado por category usando quickSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getCategory());
		}

		// Pruebas countingSort

		dataset.sortByAlgorithm("countingSort", "quality");
		System.out.println("Ordenado por quality usando countingSort: ");
		for (int i = 0; i < dataset.getData().size(); i++) {
			System.out.println(dataset.getData().get(i).getName() + " - " + dataset.getData().get(i).getQuality());
		}

		// Prueba getGamesByPrice
		ArrayList<Game> byPrice = dataset.getGamesByPrice(5000);
		System.out.println("Objetos cuyo atributo price es 5000: ");
		for (int i = 0; i < byPrice.size(); i++) {
			System.out.println(byPrice.get(i).getName() + " - " + byPrice.get(i).getPrice());
		}

		// Prueba getGamesByCategory
		ArrayList<Game> byCategory = dataset.getGamesByCategory("RPG");
		System.out.println("Objetos cuyo atributo category es RPG: ");
		for (int i = 0; i < byCategory.size(); i++) {
			System.out.println(byCategory.get(i).getName() + " - " + byCategory.get(i).getCategory());
		}

		// Prueba getGamesByQuality
		ArrayList<Game> byQuality = dataset.getGamesByQuality(80);
		System.out.println("Objetos cuyo atributo quality es 80: ");
		for (int i = 0; i < byQuality.size(); i++) {
			System.out.println(byQuality.get(i).getName() + " - " + byQuality.get(i).getQuality());
		}
	}

	public ArrayList<Game> getData() {
		return data;
	}

	public String getSortedByAttribute() {
		return sortedByAttribute;
	}
}

