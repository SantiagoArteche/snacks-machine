import java.util.ArrayList;
import java.util.List;

public class Snacks {
    public List<Snack> snacks = new ArrayList<>();

    public void addSnack(Snack snack){
        snacks.add(snack);
    }

    public void showSnacks(){
        snacks.forEach(System.out::print);
    }

    public Snack getSnack(int idSnack){
        return snacks.get(idSnack);
    }
}
