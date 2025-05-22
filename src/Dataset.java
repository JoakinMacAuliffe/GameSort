import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute = "price";
	
	Dataset(ArrayList<Game> data) {
		this.data = data;
	}
	    
	public ArrayList<Game> getGamesByPrice(int price){
	    ArrayList<Game> dataSortedByPrice = new ArrayList<>();
	    if (sortedByAttribute.equals("price") || sortedByAttribute.equals("Price")) {
			while(binarySearchByPrice(data, price) != null) {
				dataSortedByPrice.add(binarySearchByPrice(data, price));
			}
			return dataSortedByPrice;
	    } else {
			return null;
		}
	}

	public Game binarySearchByPrice(ArrayList<Game> array, int price) {
		int left = 0;
		int right = array.size() - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(array.get(mid).getPrice() == price) {
				return array.get(mid);
			} else if(array.get(mid).getPrice() > price) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return null;
	}
}
