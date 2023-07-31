// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ScannerException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку в формате ABC без пробелов, где A и C целые числа от 1 до 10 " +
                "или от I до X, а B - операция +,-,*,/");

        String input = scanner.nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) throws ScannerException {

        String[] str = input.replaceAll("\\s+","").split("[+\\-*/]");
        String[] arr = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        String[] arrRoman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String roman = "I II III IV V VI VII VIII IX X XI XII XIII XIV XV XVI XVII XVIII XIX XX XXI XXII XXIII XXIV XXV XXVI XXVII XXVIII XXIX XXX XXXI XXXII XXXIII XXXIV XXXV XXXVI XXXVII XXXVIII XXXIX XL XLI XLII XLIII XLIV XLV XLVI XLVII XLVIII XLIX L LI LII LIII LIV LV LVI LVII LVIII LIX LX LXI LXII LXIII LXIV LXV LXVI LXVII LXVIII LXIX LXX LXXI LXXII LXXIII LXXIV LXXV LXXVI LXXVII LXXVIII LXXIX LXXX LXXXI LXXXII LXXXIII LXXXIV LXXXV LXXXVI LXXXVII LXXXVIII LXXXIX XC XCI XCII XCIII XCIV XCV XCVI XCVII XCVIII XCIX C";
        String[] romans = roman.split(" ");

        int x1;
        int x2;

        int romanInArabicCount1 = Arrays.asList(arrRoman).indexOf(str[0]) + 1;
        int romanInArabicCount2 = Arrays.asList(arrRoman).indexOf(str[1]) + 1;

        int indexPlus = input.indexOf("+");
        int indexMinus = input.indexOf("-");
        int indexMultiply = input.indexOf("*");
        int indexDevide = input.indexOf("/");

        String result = "";

        if (indexPlus != -1 & Arrays.asList(arr).contains(str[0]) & Arrays.asList(arr).contains(str[1]) & str.length == 2) {
            x1 = Integer.parseInt(str[0].trim());
            x2 = Integer.parseInt(str[1].trim());
            result = Integer.toString((x1 + x2));
        } else if (indexMinus != -1 & Arrays.asList(arr).contains(str[0]) & Arrays.asList(arr).contains(str[1]) & str.length == 2) {
            x1 = Integer.parseInt(str[0].trim());
            x2 = Integer.parseInt(str[1].trim());
            result = Integer.toString((x1 - x2));
        } else if (indexMultiply != -1 & Arrays.asList(arr).contains(str[0]) & Arrays.asList(arr).contains(str[1]) & str.length == 2) {
            x1 = Integer.parseInt(str[0].trim());
            x2 = Integer.parseInt(str[1].trim());
            result = Integer.toString((x1 * x2));
        } else if (indexDevide != -1 & Arrays.asList(arr).contains(str[0]) & Arrays.asList(arr).contains(str[1]) & str.length == 2) {
            x1 = Integer.parseInt(str[0].trim());
            x2 = Integer.parseInt(str[1].trim());
            result = Integer.toString((x1 / x2));

        } else if (indexPlus != -1 & Arrays.asList(arrRoman).contains(str[0]) & Arrays.asList(arrRoman).contains(str[1]) & str.length == 2) {
            int result2 = romanInArabicCount1 + romanInArabicCount2;
            result = romans[result2 - 1];
        } else if (indexMinus != -1 & Arrays.asList(arrRoman).contains(str[0]) & Arrays.asList(arrRoman).contains(str[1]) & str.length == 2) {
            int result2 = romanInArabicCount1 - romanInArabicCount2;
            result = romans[result2 - 1];
        } else if (indexMultiply != -1 & Arrays.asList(arrRoman).contains(str[0]) & Arrays.asList(arrRoman).contains(str[1]) & str.length == 2) {
            int result2 = romanInArabicCount1 * romanInArabicCount2;
            result = romans[result2 - 1];
        } else if (indexDevide != -1 & Arrays.asList(arrRoman).contains(str[0]) & Arrays.asList(arrRoman).contains(str[1]) & str.length == 2) {
            int result2 = romanInArabicCount1 / romanInArabicCount2;
            result = romans[result2 - 1];
        } else throw new ScannerException();
        return result;
    }
}