package classes;
import exeption.EmptyDate;
import java.util.Scanner;

public class ScannerData {
    private String data;

    public ScannerData() {
        this.data = null;

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Введите следующие данные в произвольном порядке, разделенные пробелом:\n" +
                    "Фамилия Имя Отчество дата рождения \"dd.MM.yyyy\" номер телефона пол: ");
            data = sc.nextLine();
            empty(data);

        } catch (EmptyDate e) {

            System.out.println("Строка пустая повторите ввод");
        }
    }

    public void empty(String data) throws EmptyDate {
        if (data.isEmpty()) throw new EmptyDate();
    }

    public String getData() {
        return data;
    }

}
