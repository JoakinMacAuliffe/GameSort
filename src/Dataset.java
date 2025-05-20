import java.util.*;

public class Dataset{

	private ArrayList<Game> data;
	private String sortedByAttribute;
	
	Dataset(ArrayList<Game> data) this.data = data;
	    
	public ArrayList<Game> getGamesByPrice(int price){
	    
	    ArrayList<Game> lista = new ArrayList<>();
	    
	    if (this.sortedByAttribute == "price") {
	        
	        int left = 0;
	        int right = data.size()-1;
	        
	        while (left <= right) {
	            
	            int mid = (left + right) / 2;
	            
	            if (mid == "price") return mid;
	            
	            else if (mid > left) {
	                   
	                   
	               }
	        }
	    }

	}

	public ArrayList<Game> getData() {
		return data;
	}
}
