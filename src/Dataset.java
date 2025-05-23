import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute = "";

	binarySearchMethods binarySearchMethods = new binarySearchMethods();

	Dataset(ArrayList<Game> data) {
		this.data = data;
	}
	    
	public ArrayList<Game> getGamesByPrice(int price){
	    ArrayList<Game> dataSortedByPrice = new ArrayList<>();
	    if(sortedByAttribute.equalsIgnoreCase("price")) { // El atributo equivale a price ignorando mayúsculas
			int index = binarySearchMethods.binarySearchByPrice(data, price); // El índice se posiciona sobre el primer juego que coincida con el precio
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
		if(sortedByAttribute.equalsIgnoreCase("price")) {

		}
		return null;
	}

}
