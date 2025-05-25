import java.util.*;

public class Dataset {

	private ArrayList<Game> data;
	private String sortedByAttribute = "";

	searchAndSortMethods searchAndSortMethods = new searchAndSortMethods();

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

	public ArrayList<Game> getData() {
		return data;
	}

}

