import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String first_name, last_name, patronymic;
    private final LocalDate birthdate;
    private final int age;
    private final String gender;
    Person(String full_name, String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            birthdate = LocalDate.parse(date, dateFormat);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Неправильный формат даты рождения");
        }
        String[] words = full_name.split(" ");
        try {
            first_name = words[1];
            last_name = words[0];
            patronymic = words[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Полное имя введено не полностью");
        }
        age = Period.between(birthdate, LocalDate.now()).getYears();
        if (patronymic.charAt(patronymic.length() - 1) == 'a') {
            gender = "Женский";
        } else if (patronymic.charAt(patronymic.length() - 1) == 'ч') {
            gender = "Мужской";
        } else {
            gender = "";
        }
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
