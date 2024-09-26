public class Main {
    public static void main(String[] args){
        Snacks mySnacks = new Snacks();
        Snack chocolate = new Snack("Chocolate", 55.25);
        Snack hamburguer = new Snack("Hamburguesa", 122.25);
        Snack pizza = new Snack("Pizza", 77.25);
        mySnacks.addSnack(chocolate);
        mySnacks.addSnack(hamburguer);
        mySnacks.addSnack(pizza);
        SnacksMachine.startMachine(mySnacks);
    }
}
