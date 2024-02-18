import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        String data;
        String output;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите данные:");
        try {
            data = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        output = calc(data);
        System.out.println(output);




    }

    public static String calc(String input) throws IOException {
        int firstNumber = 0;
        int secondNumber = 0;
        int spaceResult;
        String mesage = "Некоректные данные!";
        String result = "";
        String sign;
        String[] sings = {"+", "-", "*", "/"};
        String[] romastr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
        "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
        "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
        "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
        "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
        "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
        "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] arr = input.split(" ");
        if (arr.length < 3) throw new IOException(mesage);
        sign = arr[1];

        if (!checkSign(sign, sings)) {
            throw new IOException(mesage);
        }

        if (checkRoma(arr[0], romastr) && checkRoma(arr[2], romastr)) {
            int i;
            for (i = 0; i <= 9; i++) {
                if (romastr[i].equals(arr[0])) firstNumber = i + 1;
            }
            for (i = 0; i <= 9; i++) {
                if (romastr[i].equals(arr[2])) secondNumber = i + 1;
            }
            spaceResult = doItBabyDoIt(firstNumber, secondNumber, sign);
                if (spaceResult > 0) {
                    result = romastr[spaceResult - 1];
                } else throw new IOException(mesage);
        } else if (checkArabian(arr[0]) && checkArabian(arr[2])){
            firstNumber = Integer.parseInt(arr[0]);
            secondNumber = Integer.parseInt(arr[2]);
            spaceResult = doItBabyDoIt(firstNumber, secondNumber, sign);
            result = Integer.toString(spaceResult);
            } else {
            throw new IOException(mesage);
            }
        return result;
        }

    public static Boolean checkRoma( String number, String[] arr){
        boolean result = false;
        int i;
        for (i = 0; i <= arr.length - 1; i++){
            if (arr[i].equals(number)){
                result = true;
            }
        }
        return result;
    }

    public static Boolean checkArabian(String number) throws IOException {
        boolean result = false;
        int n;
        try {
            n = Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IOException("Некоректные данные");
        }
        if ( 1 <= n && 10 >= n) {
            result = true ;
        }
        return result;
    }

    public static Boolean checkSign(String sign, String[] avalibleSigns){
        boolean result = false;
        int i;
        for (i = 0; i <= avalibleSigns.length - 1; i++){
            if (sign.equals(avalibleSigns[i])) result = true;
        }
        return result;
    }

    public static Integer doItBabyDoIt(int x, int y, String sign){
        int result;
        if (sign.equals("+")){
            result = x + y;
        } else if (sign.equals("-")){
            result = x - y;
        } else if (sign.equals("*")){
            result = x * y;
        } else result = x / y;
        return (int) result;
    }
}