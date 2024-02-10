//Ответьте на вопросы
//Дана скобочная последовательность: [((())()(())]]
//Можно ли считать эту последовательность правильной?
//Если ответ на предыдущий вопрос “нет”, то что необходимо в ней изменить, чтобы она стала правильной?

import java.util.ArrayList;
import java.util.Scanner;

public class Sequences {
    static ArrayList<Character> right_seq = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Введите любую скобочную последовательность, используя круглые и квадратные скобки");
        Scanner in = new Scanner(System.in);
        if (pars(in.nextLine())) {
            System.out.println("Заданная последовательность является правильной");
        } else {
            System.out.println("Введенная последовательность неправильная");
            System.out.print("Правильная последовательность: ");
            for (Character seq : right_seq) {
                System.out.print(seq);
            }
        }
    }

    public static boolean pars(String line) {
        boolean good_seq;                             // является ли последовательность правильной
        char[] open_braces = new char[line.length()]; //массив из открывающих скобок
        char point;
        int j = 0, k = 0;                             //счетчики для непарных открывающих и закрывающих скобок соответственно
        for (int i = 0; i < line.length(); i++) {
            point = line.charAt(i);
            switch (point) {
                case ('('):
                case ('['):
                    open_braces[j] = point;
                    j++;
                    right_seq.add(point);
                    break;
                case (')'):
                    if (j > 0 && open_braces[j - 1] == '(') {
                        j--;
                        right_seq.add(point);
                    } else {
                        k++;
                    }
                    break;
                case (']'):
                    if (j > 0 && open_braces[j - 1] == '[') {
                        j--;
                        right_seq.add(point);
                    } else {
                        k++;
                    }
                    break;
                default:
                    break;
            }
        }
        if (j > 0 || k > 0) {
            good_seq = false;
            for (int i = j - 1; i >= 0; i--) {
                if (open_braces[i] == '(') {
                    right_seq.add(')');
                } else if (open_braces[i] == '[') {
                    right_seq.add(']');
                }
            }
        } else good_seq = true;
        return good_seq;
    }
}