import java.util.ArrayList;

public class searchAndSortMethods {

    public int binarySearch(ArrayList<Game> arrayList, String attribute, int price1, int price2, String category, int quality){

        int left = 0;
        int right = arrayList.size() - 1;

        switch(attribute.toLowerCase()){

            case "price":

                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(arrayList.get(mid).getPrice() == price2) return mid;
                    else if(arrayList.get(mid).getPrice() > price2) right = mid - 1;
                    else left = mid + 1;
                }
                return -1;

            case "pricebyrange":

                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(arrayList.get(mid).getPrice() >= price1 && arrayList.get(mid).getPrice() <= price2) return mid;
                    else if(arrayList.get(mid).getPrice() > price2) right = mid - 1;
                    else left = mid + 1;
                }
                return -1;

            case "category":

                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arrayList.get(mid).getCategory().compareTo(category) == 0) return mid;
                    else if (arrayList.get(mid).getCategory().compareTo(category) < 0) right = mid - 1;
                    else left = mid + 1;
                }
                return -1;

            case "quality":

                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(arrayList.get(mid).getQuality() == quality) {
                        return mid;
                    } else if(arrayList.get(mid).getQuality() > quality) {
                        right = mid - 1;
                    } else if(arrayList.get(mid).getQuality() < quality) {
                        left = mid + 1;
                    }
                }
                return -1;

            default: return -1;
        }
    }

    public void bubbleSort(ArrayList<Game> arrayList, String attribute){
        int n = arrayList.size();
        switch(attribute.toLowerCase()){

            case "quality":
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
                for(int i = 0; i < n - 1; i++) {
                    for(int j = 0; j < n - 1 - i; j++) {
                        if(arrayList.get(j).getCategory().compareTo(arrayList.get(j + 1).getCategory()) > 0) {
                            // Nota: compareTo compara los valores unicode de los strings, por eso el > 0, para que vaya de A-Z
                            Game temp = arrayList.get(j);
                            arrayList.set(j, arrayList.get(j + 1));
                            arrayList.set(j + 1, temp);
                        }
                    }
                }
                break;

            case "price":
            default:
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

        }
    }

    public void insertionSort(ArrayList<Game> arrayList, String attribute){
        switch(attribute.toLowerCase()){

            case "quality":
                for(int i = 1; i < arrayList.size(); i++){
                    int value = arrayList.get(i).getQuality();
                    int aux = i - 1;
                    while(aux >= 0 && arrayList.get(aux).getQuality() > value){
                        arrayList.set(aux + 1, arrayList.get(aux));
                        aux--;
                    }
                    arrayList.set(aux + 1, arrayList.get(i));
                }
                break;

            case "category":
                for(int i = 1; i < arrayList.size(); i++){
                    String value = arrayList.get(i).getCategory();
                    int aux = i - 1;
                    while(aux >= 0 && arrayList.get(aux).getCategory().compareTo(value) > 0){
                        arrayList.set(aux + 1, arrayList.get(aux));
                        aux--;
                    }
                    arrayList.set(aux + 1, arrayList.get(i));
                }
                break;

            case "price":
            default:
                for(int i = 1; i < arrayList.size(); i++){
                    int value = arrayList.get(i).getPrice();
                    int aux = i - 1;
                    while(aux >= 0 && arrayList.get(aux).getPrice() > value){
                        arrayList.set(aux+1, arrayList.get(aux));
                        aux--;
                    }
                    arrayList.set(aux + 1, arrayList.get(i));
                }
                break;
        }
    }

    public void selectionSort(ArrayList<Game> arrayList, String attribute) {
        int n = arrayList.size();
        switch(attribute.toLowerCase()) {

            case "quality":
                for(int i = 0; i < n - 1; i++) {
                    int minimumIndex = i;
                    for(int j = i + 1; j < n; j++) {
                        if(arrayList.get(j).getQuality() < arrayList.get(minimumIndex).getQuality()) {
                            minimumIndex = j;
                        }
                    }
                    Game temp = arrayList.get(minimumIndex);
                    arrayList.set(minimumIndex, arrayList.get(i));
                    arrayList.set(i, temp);
                }
                break;

            case "category":
                for(int i = 0; i < n - 1; i++) {
                    int minimumIndex = i;
                    for(int j = i + 1; j < n; j++) {
                        if(arrayList.get(j).getCategory().compareTo(arrayList.get(minimumIndex).getCategory()) < 0) {
                            minimumIndex = j;
                        }
                    }
                    Game temp = arrayList.get(minimumIndex);
                    arrayList.set(minimumIndex, arrayList.get(i));
                    arrayList.set(i, temp);
                }
                break;

            case "price":
            default:
                for(int i = 0; i < n - 1; i++) {
                    int minimumIndex = i;
                    for(int j = i + 1; j < n; j++) {
                        if(arrayList.get(j).getPrice() < arrayList.get(minimumIndex).getPrice()) {
                            minimumIndex = j;
                        }
                    }
                    Game temp = arrayList.get(minimumIndex);
                    arrayList.set(minimumIndex, arrayList.get(i));
                    arrayList.set(i, temp);
                }
                break;

        }
    }

    public void mergeSort(ArrayList<Game> arrayList, String attribute) {
        if(arrayList.size() <= 1) return;

        int mid = arrayList.size() / 2;

        ArrayList<Game> left = new ArrayList<>(arrayList.subList(0, mid));
        ArrayList<Game> right = new ArrayList<>(arrayList.subList(mid, arrayList.size()));

        mergeSort(left, attribute);
        mergeSort(right, attribute);

        int i = 0, j = 0, k = 0;
        while(i < left.size() && j < right.size()) {
            boolean takeLeft = false;
            switch (attribute.toLowerCase()) {
                case "quality":
                    takeLeft = left.get(i).getQuality() <= right.get(j).getQuality();
                    break;
                case "category":
                    takeLeft = left.get(i).getCategory().compareTo(right.get(j).getCategory()) <= 0;
                    break;
                case "price":
                default:
                    takeLeft = left.get(i).getPrice() <= right.get(j).getPrice();
                    break;
            }
            if(takeLeft) {
                arrayList.set(k++, left.get(i++));
            } else {
                arrayList.set(k++, right.get(j++));
            }
        }
        while(i < left.size()) {
            arrayList.set(k++, left.get(i++));
        }
        while(j < right.size()) {
            arrayList.set(k++, right.get(j++));
        }
    }

    public void quickSort(ArrayList<Game> arrayList, String attribute) {
        if (arrayList == null || arrayList.size() <= 1) return;

        int n = arrayList.size();
        java.util.Stack<int[]> stack = new java.util.Stack<>();

        stack.push(new int[]{0, n - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int low = range[0], high = range[1];
            if (low >= high) continue;
            Game pivot = arrayList.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                boolean condition = false;
                switch (attribute.toLowerCase()) {
                    case "quality":
                        condition = arrayList.get(j).getQuality() <= pivot.getQuality();
                        break;
                    case "category":
                        condition = arrayList.get(j).getCategory().compareTo(pivot.getCategory()) <= 0;
                        break;
                    case "price":
                    default:
                        condition = arrayList.get(j).getPrice() <= pivot.getPrice();
                        break;
                }
                if (condition) {
                    i++;
                    Game temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
            Game temp = arrayList.get(i + 1);
            arrayList.set(i + 1, arrayList.get(high));
            arrayList.set(high, temp);
            int pi = i + 1;
            stack.push(new int[]{low, pi - 1});
            stack.push(new int[]{pi + 1, high});
        }
    }

}
