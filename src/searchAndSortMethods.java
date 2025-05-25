import java.util.ArrayList;

public class searchAndSortMethods {

    public int binarySearch(ArrayList<Game> arrayList, String mode, int price1, int price2, String category, int quality){

        switch(mode){

            case "price":

                int left = 0;
                int right = arrayList.size() - 1;

                while(left <= right) {

                    int mid = (left + right) / 2;

                    if(arrayList.get(mid).getPrice() == price2) return mid;

                    else if(arrayList.get(mid).getPrice() > price2) right = mid - 1;

                    else left = mid + 1;
                }

                return -1;
                break;

            case "pricebyrange":

                int left = 0;
                int right = arrayList.size() - 1;

                while(left <= right) {

                    int mid = (left + right) / 2;

                    if(arrayList.get(mid).getPrice() >= price1 && arrayList.get(mid).getPrice() <= price2) return mid;

                    else if(arrayList.get(mid).getPrice() > price2) right = mid - 1;

                    else left = mid + 1;

                }

                return -1;
                break;

            case "category":

                int left = 0;
                int right = arrayList.size() - 1;

                while (left <= right) {

                    int mid = (left + right) / 2;

                    if (arrayList.get(mid).getCategory().compareTo(category) == 0) return mid;

                    else if (arrayList.get(mid).getCategory().compareTo(category) > 0) right = mid - 1;

                    else left = mid + 1;
                }

                return -1;
                break;

            case "quality":

                int left = 0;
                int right = arrayList.size() - 1;

                while (left <= right){

                    int mid = (left + right) / 2;

                    if(arrayList.get(mid).getQuality() == quality) {
                        return mid;
                    }else if(arrayList.get(mid).getQuality() > quality){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }

                return -1;
                break;

            default: return -1;
        }
    }

   

    public void bubbleSort(ArrayList<Game> arrayList, String attribute){

        switch(attribute){

            case "price":

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
                break;

            case "quality":

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
                break;

            case "category":

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
                break;

            default: return;
        }
    }

    public void insertionSort(ArrayList<Game> arrayList, String attribute){

        switch(attribute){

            case "price":

                for(int i=1; i<arrayList.size(); i++){

                    int value = arrayList.get(i).getPrice();
                    int aux = i - 1;

                    while(aux >= 0 && arrayList.get(aux).getPrice() > value){

                        arrayList.set(aux+1, arrayList.get(aux));
                        aux--;
                    }

                    arrayList.set(aux+1, arrayList.get(i));
                }
                break;

            case "quality":

                for(int i=1; i<arrayList.size(); i++){

                    int value = arrayList.get(i).getQuality();
                    int aux = i - 1;

                    while(aux >= 0 && arrayList.get(aux).getQuality() > value){

                        arrayList.set(aux+1, arrayList.get(aux));
                        aux--;
                    }

                    arrayList.set(aux+1, arrayList.get(i));
                }
                break;

            case "category":

                for(int i=1; i<arrayList.size(); i++){

                    String value = arrayList.get(i).getCategory();
                    int aux = i - 1;

                    while(aux >= 0 && arrayList.get(aux).getCategory().compareTo(value) > 0){

                        arrayList.set(aux+1, arrayList.get(aux));
                        aux--;
                    }

                    arrayList.set(aux+1, arrayList.get(i));
                }
                break;

            default: return;
        }
    }
}
