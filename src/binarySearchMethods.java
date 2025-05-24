import java.util.ArrayList;

public class binarySearchMethods {

    public int binarySearchByPrice(ArrayList<Game> arrayList, int price) {

        int left = 0;
        int right = arrayList.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arrayList.get(mid).getPrice() == price) {
                return mid;
            } else if(arrayList.get(mid).getPrice() > price) {
                right = mid - 1;
            } else if(arrayList.get(mid).getPrice() < price) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchByPriceRange(ArrayList<Game> arrayList, int lowerPrice, int higherPrice) {
        int left = 0;
        int right = arrayList.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arrayList.get(mid).getPrice() >= lowerPrice && arrayList.get(mid).getPrice() <= higherPrice) {
                return mid;
            } else if(arrayList.get(mid).getPrice() > higherPrice) {
                right = mid - 1;
            } else if(arrayList.get(mid).getPrice() < lowerPrice){
                left = mid + 1;
            }
        }
        return -1;
    }

}
