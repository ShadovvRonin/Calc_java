import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Converter converter = new Converter();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        String[] data;
        String action;

        if (str.contains("+")) {
            data = str.split("\\+");
            action = "+";
        } else if (str.contains("-")) {
            data = str.split("-");
            action = "-";
        } else if (str.contains("*")) {
            data = str.split("\\*");
            action = "*";
        } else if (str.contains("/")) {
            data = str.split("/");
            action = "/";
        } else {
            throw new IOException("Не содержит операнда");
        }
        String[] number = str.split ("[+\\-*/]");
        if (number.length !=2)
            throw new IOException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *");

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){

            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if (a > 10 || b > 10) {
                throw new Exception("Вводимые числа должны быть записанны от 0 до 10");
            }

            int result;
            switch (action){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }

            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }
    }
}
