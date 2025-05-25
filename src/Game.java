public class Game {

    private String name;
    private String category;
    private int price;
    private int quality;

    Game(String name, String category, int price, int quality) {

        this.name = name;
        this.category = category;

        if (price >= 0) {
           this.price = price;
        }

        if (quality >= 0 && quality <= 100) {
            this.quality = quality;
        }

    }

    public int getPrice() {
        return price;
    }

    public int getQuality() {
        return quality;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
