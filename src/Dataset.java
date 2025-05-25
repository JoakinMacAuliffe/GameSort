import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute = "";

	searchAndSortMethods searchAndSortMethods = new searchAndSortMethods();

	Dataset(ArrayList<Game> data) {
		this.data = data;
	}
	    
	public ArrayList<Game> getGamesByPrice(int price){

	    ArrayList<Game> dataSortedByPrice = new ArrayList<>();

		if(sortedByAttribute.equalsIgnoreCase("price")) { // El atributo equivale a price ignorando mayúsculas

			int index = searchAndSortMethods.binarySearch(data, "price", 0, price, "null"); // El índice se posiciona sobre el primer juego que coincida con el precio
			if(index == -1) return dataSortedByPrice; // No existe ningún juego con ese precio, retorna lista vacía

			dataSortedByPrice.add(data.get(index));

			int left = index - 1;
			while(left >= 0 && data.get(left).getPrice() == price) {
				dataSortedByPrice.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while(right < data.size() && data.get(right).getPrice() == price) {
				dataSortedByPrice.add(data.get(right));
				right++;
			}

			return dataSortedByPrice;
	    } else {
			for(int i = 0; i < data.size(); i++) { // Busqueda lineal
				if(data.get(i).getPrice() == price){
					dataSortedByPrice.add(data.get(i));
				}
			}
			return dataSortedByPrice;
		}
	}

	public ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice) {
		ArrayList<Game> dataSortedByPriceRange = new ArrayList<>();
		if(sortedByAttribute.equalsIgnoreCase("price")) {

			int index = searchAndSortMethods.binarySearch(data, "pricebyrange", lowerPrice, higherPrice, "null");
			if(index == -1) return dataSortedByPriceRange;

			dataSortedByPriceRange.add(data.get(index));

			int left = index - 1;
			while(left >= 0 && data.get(left).getPrice() >= lowerPrice
					&& data.get(left).getPrice() <= higherPrice) {
				dataSortedByPriceRange.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while(right < data.size() && data.get(right).getPrice() <= higherPrice
					&& data.get(right).getPrice() >= lowerPrice) {
				dataSortedByPriceRange.add(data.get(right));
				right++;
			}

			return dataSortedByPriceRange;

		} else {
			for(int i = 0; i < data.size(); i++) {
				if(data.get(i).getPrice() >= lowerPrice
						&& data.get(i).getPrice() <= higherPrice) {
					dataSortedByPriceRange.add(data.get(i));
				}
			}
			return dataSortedByPriceRange;
		}
	}

	public ArrayList<Game> getGamesByCategory(String category){

		ArrayList<Game> dataSortedByCategory = new ArrayList<>();

		if(sortedByAttribute.equalsIgnoreCase("category")) {

			int index = searchAndSortMethods.binarySearch(data, "category",0, 0, category);

			if(index == -1) return dataSortedByCategory;

			dataSortedByCategory.add(data.get(index));

			int left = index - 1;

			while(left >= 0 && data.get(left).getCategory().compareTo(category) == 0) {

				dataSortedByCategory.add(data.get(left));
				left--;
			}

			int right = index + 1;

			while(right < data.size() && data.get(right).getCategory().compareTo(category) == 0) {

				dataSortedByCategory.add(data.get(right));
				right++;
			}
		}
		else {

			for(int i = 0; i < data.size(); i++) {

				if(data.get(i).getCategory().compareTo(category) == 0) dataSortedByCategory.add(data.get(i));
			}
		}

		return dataSortedByCategory;
	}

	public ArrayList<Game> getGamesByQuality (int quality){
		ArrayList<Game> dataSortedByQuality = new ArrayList<>();

		if(sortedByAttribute.equalsIgnoreCase("quality")){

			int index = searchAndSortMethods.binarySearchByQuality(data, quality);
			if(index == -1) return dataSortedByQuality;

			dataSortedByQuality.add(data.get(index));

			int left = index -1;

			while(left >=0 && data.get(left).getQuality() == quality){

				dataSortedByQuality.add(data.get(left));
				left--;
			}

			int right = index + 1;
			while(right < data.size() && data.get(right).getQuality() == quality) {
				dataSortedByQuality.add(data.get(right));
				right++;
			}

			return dataSortedByQuality;

		} else {

			for(int i = 0; i < data.size(); i++){

				if(data.get(i).getQuality() == quality){

					dataSortedByQuality.add(data.get(i));
				}
			}
			return dataSortedByQuality;
		}

	}

	public void sortByAlgorithm(String algorithm, String attribute) {

		this.sortedByAttribute = attribute.toLowerCase();

		switch(algorithm.toLowerCase()) { // el string algorithm se convierte a minúsculas de tal manera de que no afecten las mayúsculas en el switch

			case "bubblesort": searchAndSortMethods.bubbleSort(data, attribute); break;

			case "insertionsort": searchAndSortMethods.insertionSort(data, attribute); break;

			case "selectionsort":

				if(attribute.equalsIgnoreCase("category")) {

					this.sortedByAttribute = "category";
				}
				else if(attribute.equalsIgnoreCase("quality")) {

					this.sortedByAttribute = "quality";
				}
				else { // En cualquier otro caso, ordenar por atributo price

					this.sortedByAttribute = "price";
				}
				break;
			case "mergesort":

				if(attribute.equalsIgnoreCase("category")) {

					this.sortedByAttribute = "category";
				}
				else if(attribute.equalsIgnoreCase("quality")) {

					this.sortedByAttribute = "quality";
				}
				else { // En cualquier otro caso, ordenar por atributo price

					this.sortedByAttribute = "price";
				}
				break;
			case "quicksort":

				if(attribute.equalsIgnoreCase("category")) {

					this.sortedByAttribute = "category";
				}
				else if(attribute.equalsIgnoreCase("quality")) {

					this.sortedByAttribute = "quality";
				}
				else { // En cualquier otro caso, ordenar por atributo price

					this.sortedByAttribute = "price";
				}
				break;
			default:
				// Collections.sort();
				if(sortedByAttribute.equalsIgnoreCase("category")) {
					Collections.sort(data, new Comparator<Game>() {
						@Override
						public int compare(Game game1, Game game2) {
							return game1.getCategory().compareTo(game2.getCategory());
						}
					});
				} else if(sortedByAttribute.equalsIgnoreCase("quality")) {
					Collections.sort(data, new Comparator<Game>() {
						@Override
						public int compare(Game game1, Game game2) {
							return Integer.compare(game1.getQuality(), game2.getQuality());
						}
					});
				} else { // En cualquier otro caso, ordenar por atributo price
					Collections.sort(data, new Comparator<Game>() {
						@Override
						public int compare(Game game1, Game game2) {
							return Integer.compare(game1.getPrice(), game2.getPrice());
						}
					});
				}

		}
	}

}
