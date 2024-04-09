import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полное имя в формате ФИО ->");
        String full_name = scanner.nextLine();
        System.out.print("Введите дату рождения в формате dd.mm.yyyy ->");
        String date = scanner.next();
        Person p = new Person(full_name, date);
        System.out.format("Имя: %s %c. %c.\n", p.getLast_name(), p.getFirst_name().charAt(0), p.getPatronymic().charAt(0));
        System.out.format("Пол: %s\nВозраст: %d", p.getGender(), p.getAge());
    }
}
