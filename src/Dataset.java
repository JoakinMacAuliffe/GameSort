import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute = "price";
	
	Dataset(ArrayList<Game> data) {
		this.data = data;
	}
	    
	public ArrayList<Game> getGamesByPrice(int price){
	    ArrayList<Game> dataSortedByPrice = new ArrayList<>();
	    if(sortedByAttribute.equalsIgnoreCase("price")) { // El atributo equivale a price ignorando mayúsculas
			int index = binarySearchByPrice(data, price); // El índice se posiciona sobre el primer juego que coincida con el precio
			if(index == -1) return null; // No existe ningún juego con ese precio

			int left = index + 1;
			while(left >= 0 && data.get(left).getPrice() == price) {
				dataSortedByPrice.add(data.get(index));
				left--;
			}

			int right = index - 1;
			while(right < data.size() && data.get(right).getPrice() == price) {
				dataSortedByPrice.add(data.get(index));
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

	public int binarySearchByPrice(ArrayList<Game> array, int price) {
		int left = 0;
		int right = array.size() - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array.get(mid).getPrice() == price) {
				return mid;
			} else if(array.get(mid).getPrice() > price) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
