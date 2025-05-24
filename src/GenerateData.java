import java.util.*;

public class GenerateData{

    String setName(){

        Random random = new Random();

        String[] name = new String[] {

                "Super", "Galaxy", "League", "Shadow", "Pergio", "Sinto", "Tliver", "Ourbes",
                "ACV", "Dream", "Strike", "Manager", "Do", "While", "Geometry", "Half", "Over",
                "Bro",
        };

        int index1 = random.nextInt(18);
        int index2 = random.nextInt(18);

        while(index2 == index1){

            index2 = random.nextInt(18);
        }

        return name[index1] + name[index2];
    }

    String setCategory(){

        Random random = new Random();

        String[] category = new String[] {

                "Accion", "Aventura", "Estrategia", "RPG", "Deportes", "Simulacion", "Shooter",
                "Carreras", "MundoLibre", "MMO", "Plataformas"
        };

        int index = random.nextInt(11);

        return category[index];
    }

    int setPrice(){

        Random random = new Random();

        return random.nextInt(69001) + 1000; //valor entre 1.000 - 70.000
    }

    int setQuality(){

        Random random = new Random();

        return random.nextInt(101); //valor entre 0 - 100
    }

    ArrayList<Game> generateGame(int n){

        ArrayList<Game> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++){

            String name = setName(), category = setCategory();
            int price = setPrice(), quality = setQuality();

            Game game = new Game(name, category, price, quality);

            arrayList.add(game);
        }

        return arrayList;
    }
}
