import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Counter_id counter;
    private Store store;
    private Lottery lottery;
    private ArrayList<Toy> toys;

    public void showStore(ArrayList<Toy> toys) {

        System.out.printf("%-5s%-15s%-10s%-22s\n", "Id", "Имя", "количество", "частота");
        for (Toy toy : toys)
            System.out.printf("%-5d%-15s%-10d%-22f\n", toy.getId(), toy.getName(), toy.getQuantity(), toy.getFrequency());

    }


    public void userMenu(Store store, Counter_id counter, ArrayList <Toy> toys) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n ВЫБЕРЕТЕ НОМЕР КОМАНДЫ В МЕНЮ\n" +
                    "1 - список игрушек в магазине\n" +
                    "2 - начать розыгрыш игрушек\n" +
                    "3 - изменить частоту игрушки по ID\n" +
                    "4 - добавить игрушку в магазин\n" +
                    "5 - удалить игрушку в магазине\n" +
                    "6 - изменить параметры игрушки в магазине\n" +
                    "7 - выход из розыгрыша");

            Scanner in = new Scanner(System.in);

            String user_input = in.next();
            if (user_input.contains("1")) {
                System.out.println("\nигрушки в магазине:");
                showStore(store.getToys());
            } else if (user_input.contains("2")) {
                Lottery lottery = new Lottery(store.getToys());
                lottery.choiceOfPrizesRandom(store.getToys());
                Toy prizeToy = lottery.getPrizeToy();
                if (prizeToy != null) {
                    System.out.println("\nВыигрышная игрушка: " + prizeToy.getName() + '\n');
                }
            } else if (user_input.contains("3")) {
                System.out.println("Введите id: ");
                int id = Integer.parseInt(in.next());
                System.out.println("Введите новую частоту: ");
                double newFrequency = Double.parseDouble(in.next());
                if (newFrequency > 0 && newFrequency < 100) {
                    if (!store.changeToyFrequency(id, newFrequency)) {
                        System.out.println("id не существует");
                    } else {
                        System.out.println("успешное изменение\n");
                    }
                } else {
                    System.out.println("ведите в диапазоне от 0 to 100\n");
                }

            } else if (user_input.contains("4")) {

                System.out.println("Введите новое имя игрушки: ");
                String name = in.next();
                System.out.println("Введите новое количество игрушек: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag1 = true;
                System.out.println("Введите новую частоту игрушки: ");
                double frequency = Double.parseDouble(in.next());
                while (flag1) {
                    if (frequency > 0 && frequency < 100) {
                        flag1 = false;
                    } else {
                        System.out.println("Входная частота игрушки в диапазоне от 0 to 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                store.addToy(new Toy(counter.getId(), name, quantity, frequency));
                System.out.println("Добавлена ​​новая игрушка! ");

            }else if (user_input.contains("5")) {
                System.out.println("Введите какую игрушку нужно удалить!: ");
                String name = in.next();
                store.deleteToyFromStore(toys, name);
            }else if (user_input.contains("6")){
                System.out.println("Введите название игрушки, чтобы изменить ее параметры: ");
                String name = in.next();
                System.out.println("Ввести количество игрушек: ");
                int quantity = Integer.parseInt(in.next());
                boolean flag2 = true;
                System.out.println("Вводимая Частота игрушки: ");
                double frequency = Double.parseDouble(in.next());
                while (flag2) {
                    if (frequency > 0 && frequency < 100) {
                        flag2 = false;
                    } else {
                        System.out.println("Входная частота игрушки в диапазоне от0 to 100: ");
                        frequency = Double.parseDouble(in.next());
                    }
                }
                if(store.changeToy(name, quantity, frequency)){
                    System.out.println("параметры игрушки " + name + " изменен!" );
                }
                else{
                    System.out.println(name + " не существует в магазине!" );
                }

            }














            else {
                flag = false;

            }
        }

    }

}