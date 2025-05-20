import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute;
	
	Dataset(ArrayList<Game> data) {
		this.data = data;
	}
	    
	public ArrayList<Game> getGamesByPrice(int price){
	    
	    ArrayList<Game> lista = new ArrayList<>();
	    
	    if (sortedByAttribute == "price") {
			binarySearch()
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
