import java.util.ArrayList;

public class searchAndSortMethods {

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

    public void bubbleSortByPrice(ArrayList<Game> arrayList) {
        int n = arrayList.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arrayList.get(j).getPrice() > arrayList.get(j + 1).getPrice()) {
                    Game temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortByQuality(ArrayList<Game> arrayList) {
        int n = arrayList.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arrayList.get(j).getQuality() > arrayList.get(j + 1).getQuality()) {
                    Game temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
    }

    public void bubbleSortByCategory(ArrayList<Game> arrayList) {
        int n = arrayList.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arrayList.get(j).getCategory().compareTo(arrayList.get(j + 1).getCategory()) > 0) {
                    // Nota: compareTo compara los valores unicode de los strings, por eso el > 0
                    Game temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
    }

}
