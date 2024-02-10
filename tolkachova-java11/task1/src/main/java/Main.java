//Задание
//Составьте алгоритм
//Если введенное число больше 7, то вывести “Привет”
//Если введенное имя совпадает с “Вячеслав”, то вывести “Привет, Вячеслав”, если нет, то вывести "Нет такого имени"
//На входе есть числовой массив, необходимо вывести элементы массива кратные 3

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите число");
        try {
            do_number(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Число введено некорректно");
        }

        System.out.println("Введите имя");
        do_name(input.nextLine());

        System.out.println("Введите числовой массив");
        do_array(input.nextLine());

        input.close();
    }

    private static void do_number(String str) {
        if (Double.parseDouble(str) > 7) {
            System.out.println("Привет");
        }
    }

    private static void do_name(String str) {
        if (str.equals("Вячеслав")) {
            System.out.println("Привет, Вячеслав");
        } else
            System.out.println("Нет такого имени");
    }

    private static void do_array(String str) {
        Pattern pattern_number = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher matcher_double = pattern_number.matcher(str);
        ArrayList<Double> array = new ArrayList<>();
        while (matcher_double.find()) {
            array.add(Double.valueOf(matcher_double.group()));
        }
        System.out.print("Элементы массива " + array + ", кратные 3: ");
        boolean no_elements = true;
        for (Double var : array) {
            if (var % 3 == 0) {
                System.out.print(var + "  ");
                no_elements = false;
            }
        }
        if (no_elements) {
            System.out.println(" не найдены");
        }
    }
}
