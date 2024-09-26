import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnacksMachine {
    static List<Snack> ticket = new ArrayList();
    static Scanner scanner = new Scanner(System.in);

    public static void startMachine(Snacks mySnacks){
        System.out.println("--- Maquina de Snacks ---");
        System.out.println("--- Inventario ---");
        showMenu(mySnacks);
        executeOptions(mySnacks);
    }

    private static void showMenu(Snacks mySnacks){
        mySnacks.showSnacks();
        System.out.println("""
                \nMenu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo Snack
                4. Salir
                Elige una opcion:""");

    }

    private static void executeOptions(Snacks mySnacks) {
        boolean execution = false;
        while (!execution) {
            showMenu(mySnacks);
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> buySnack(mySnacks);
                case 2 -> showTicket();
                case 3 -> addSnack(mySnacks);
                case 4 -> {
                    System.out.println("Programa finalizado");
                    execution = true;
                }
                default -> System.out.println("Esta opcion no existe\n");
            }
        }
    }


    private static void addSnack(Snacks mySnacks){
        System.out.println("Ingresa el nombre de tu snack: ");
        String name = scanner.next();
        System.out.println("Ingresa el precio de tu snack: ");
        double price = Double.parseDouble(scanner.next());
        Snack newSnack = new Snack(name, price);
        mySnacks.addSnack(newSnack);
        System.out.print("Snack agregado!");
        System.out.println("Ingresa cualquier numero para volver al menu");;
        scanner.next();
    }

    private static void buySnack(Snacks mySnacks){
        System.out.println("Que snack quieres comprar: ");
        try{
            int idSnack = scanner.nextInt();
            Snack snackBought = mySnacks.getSnack(idSnack);
            if(!snackBought.toString().isEmpty()){
                SnacksMachine.ticket.add(snackBought);
                System.out.println("Snack comprado!");
                System.out.println("Ingresa cualquier numero para volver al menu");;
                scanner.next();
            }
        }catch (Exception e){
            System.out.println("El snack buscado no existe, reingresa un id valido!");
            buySnack(mySnacks);
        }
    }

    private static void showTicket(){
        String mySnacksBougth = "";
        double total = 0;
        for(var element: SnacksMachine.ticket){
            mySnacksBougth += element.toString();
            total += element.getPrice();
        }
        System.out.println("""
                Elementos comprados:
                %s 
                Precio final:
                $%.2f
                """.formatted(mySnacksBougth, total));
        System.out.println("Ingresa cualquier numero para volver al menu");
        scanner.next();
    }
}
