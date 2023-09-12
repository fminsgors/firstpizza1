import java.util.Scanner;
import java.util.ArrayList;

public class Pizza {
    String bacon = "бекон";
    String cheese = "сыр";
    String ham = "ветчина";
    String tomato = "помидоры";
    String sauce = "соус";
    ArrayList<String> topping = new ArrayList<>();
    int slices = 0;
    Scanner scanner = new Scanner(System.in);

//    public Pizza(String bacon , String cheese, String ham, String tomato, String sauce, int slices) {
//        this.bacon = bacon;
//        this.cheese = cheese;
//        this.ham = ham;
//        this.tomato = tomato;
//        this.sauce = sauce;
//        this.slices=slices;
//    }
    void bake() {
        System.out.println("Вы выпекли пиццу");
    }

    void put() {
        Boolean f = true;
        ArrayList<String> putin = new ArrayList<>();
        putin.add("Бекон");
        putin.add("Сыр");
        putin.add("Ветчина");
        putin.add("Помидоры");
        putin.add("Соус");
        putin.add("Выход");
        boolean[] selected = new boolean[putin.size()];
        for (int j = 0; j < putin.size(); j++) {
            selected[j] = true;
        }
        while (f) {
            System.out.println("Начнем с ..?");
            for (int i = 0; i < putin.size(); i++) {
                if (selected[i]) {
                    System.out.println((i) + ". " + putin.get(i));
                }
            }
            int number = scanner.nextInt();
            if (number == 5) {
                f = false;
            } else if (number >= 0 && number < putin.size()) {
                String toppings = putin.get(number);
                topping.add(toppings);
                selected[number] = false;
            } else {
                System.out.println("Неправильный номер. Выберите еще раз");
            }

        }
    }

    void cut() {
        System.out.print("Введите количество кусочков, на которые нужно разрезать: ");
        int number = scanner.nextInt();
        slices = number;
        System.out.println(slices);
    }

    void eat() {
        System.out.println("Кусочков осталось: " + slices);
        System.out.print("Введите количество кусочков, сколько вы хотите съесть: ");
        int in = scanner.nextInt();
        if (in >= 5) {
            System.out.println("Вы съели " + in + " кусков");
        } else if (1 < in && in < 5) {
            System.out.println("Вы съели " + in + " куска");
        } else if (in == 1) {
            System.out.println("Вы съели " + in + " кусок");
        } else if (in > slices) {
            System.out.println("Вы не можете съесть кусков больше, чем их есть");
        } else if (in < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        slices = slices - in;
        if (slices >= 5) {
            System.out.println("Осталось " + slices + " кусков");
        } else if (1 < slices && slices < 5) {
            System.out.println("Осталось " + slices + " куска");
        } else if (slices == 1) {
            System.out.println("Остался " + slices + " кусок");
        } else {
            System.out.println("Ничего не осталось");

        }
    }

    void menubar() {
        Boolean flag = true;
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Добавить начинку");
        menu.add("Испечь пиццу");
        menu.add("Разрезать пиццу");
        menu.add("Съесть пиццу");
        menu.add("Выход");
        boolean[] selected = new boolean[menu.size()];
        for (int j = 0; j < menu.size(); j++) {
            selected[j] = true;
        }
        while (flag) {
            Boolean fl = true;
            System.out.println("Начнем с ..?");
            for (int i = 0; i < menu.size(); i++) {
                if (selected[i]) {
                    System.out.println((i) + ". " + menu.get(i));
                }
            }
            int number = scanner.nextInt();
            while (fl) {
                if (number == 0) {
                    put();
                    System.out.println("Ваша начинка в пицце " + topping);
                    fl = false;
                    selected[number] = false;
                } else if (number == 1) {
                    bake();
                    fl = false;
                    selected[number] = false;
                } else if (number == 2) {
                    cut();
                    System.out.println("Вы разрезали пиццу на " + slices);
                    fl = false;
                    selected[number] = false;
                } else if (number == 3) {
                    eat();
                    System.out.println("Вы покушали");
                    fl = false;
                    selected[number] = false;
                } else if (number == 4) {
                    System.out.println("Спасибо за визит");
                    flag = false;
                    break;
                } else {
                    System.out.println("Неправильный номер. Выберите еще раз");
                    fl = false;
                }

            }
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        System.out.println("Приветствую, сегодня мы с вами полностью создадим пиццу");
        pizza.menubar();
    }
}