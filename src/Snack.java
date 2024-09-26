public class Snack {
    static int countSnacks = 0;
    private int idSnack;
    private String name;
    private double price;


    public Snack(String name, double price){
        this.name = name;
        this.price = price;
        this.idSnack = ++countSnacks;
    }

    public String toString(){
        return """
                Snack{id=%d, name=%s, price=$%.2f}
                """.formatted(this.idSnack, this.name, this.price);
    }

    public int getIdSnack(){
        return this.idSnack;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
