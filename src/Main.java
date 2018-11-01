import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static Scanner in = new Scanner(System.in);
    private static HashMap<String, Integer> machine = new HashMap<>();


    public static void main(String[] args) {
        String input = "";
        machine.put("water", 400);
        machine.put("milk", 540);
        machine.put("beans", 120);
        machine.put("cups", 9);
        machine.put("money", 550);
        while (!input.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            input = in.next();
            switch (input) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printContain();
                    break;
            }
        }
    }
    private static void printContain(){
        System.out.println("The coffee machine has:");
        System.out.println(machine.get("water") + " of water");
        System.out.println(machine.get("milk") + " of milk");
        System.out.println(machine.get("beans") + " of coffee beans");
        System.out.println(machine.get("cups") + " of disposable cups");
        System.out.println(machine.get("money") + " of money");
    }
    private static void buy(){
        String  input;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        input = in.next();
        switch (input){
            case "1":
                if(check(1)) {
                    machine.put("water", (machine.get("water") - 250));
                    machine.put("beans", (machine.get("beans") - 16));
                    machine.put("money", (machine.get("money") + 4));
                    machine.put("cups", machine.get("cups") - 1);
                }
                break;
            case "2":
                if(check(2)) {
                    machine.put("water", (machine.get("water") - 350));
                    machine.put("milk", (machine.get("milk") - 75));
                    machine.put("beans", (machine.get("beans") - 20));
                    machine.put("money", (machine.get("money") + 7));
                    machine.put("cups", machine.get("cups") - 1);
                }
                    break;
            case "3":
                if(check(3)) {
                    machine.put("water", (machine.get("water") - 200));
                    machine.put("milk", (machine.get("milk") - 100));
                    machine.put("beans", (machine.get("beans") - 12));
                    machine.put("money", (machine.get("money") + 6));
                    machine.put("cups", machine.get("cups") - 1);
                }
                    break;
            case "back":
                break;
        }
    }
    private static void fill(){
        System.out.println("Write how many ml of water do you want to add: ");
        machine.put("water", machine.get("water") + in.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        machine.put("milk", machine.get("milk") + in.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        machine.put("beans", machine.get("beans") + in.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        machine.put("cups", machine.get("cups") + in.nextInt());
    }
    private static void take(){
        System.out.println("I gave you $" + machine.get("money"));
        machine.put("money", 0);
    }
    private static boolean check(int coffee){
        if(coffee == 1 ) {
            if (machine.get("water") < 250) {
                System.out.println("Sorry, not enough water!");
                return false;
            } else if (machine.get("beans") < 16) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            } else if (machine.get("cups") < 1) {
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            } else {
                System.out.println("I have enough resources, making you a coffee!");
            }
        }else if(coffee == 2) {
            if (machine.get("water") < 350) {
                System.out.println("Sorry, not enough water!");
                return false;
            } else if (machine.get("beans") < 20) {
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            } else if (machine.get("cups") < 1) {
                System.out.println("Sorry, not enough disposable cups!");
                return false;
            } else if (machine.get("milk") < 75) {
                System.out.println("Sorry, not enough milk!");
                return false;
            } else {
                System.out.println("I have enough resources, making you a coffee!");
            }
        }else {
                if(machine.get("water") < 200){
                    System.out.println("Sorry, not enough water!");
                    return false;
                }else if(machine.get("beans") < 12){
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }else if(machine.get("cups") < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    return false;
                }else if(machine.get("milk") < 100){
                    System.out.println("Sorry, not enough milk!");
                    return false;
                }else{
                    System.out.println("I have enough resources, making you a coffee!");
                }
        }
        return true;
    }
}
