import java.util.Map;
import java.util.TreeMap;

class NumberService {

    private final static TreeMap < Integer, String > romanString = new TreeMap<>();

    static {
        romanString.put(1, "I");
        romanString.put(4, "IV");
        romanString.put(5, "V");
        romanString.put(9, "IX");
        romanString.put(10, "X");
        romanString.put(40, "XL");
        romanString.put(50, "L");
        romanString.put(90, "XC");
        romanString.put(100, "C");
    }

    static Number parseAndValidate(String symbol) throws Exception {

        int value;
        Alphabet alphabet;

        try {
            value = Integer.parseInt(symbol);
            alphabet = Alphabet.ARABIC;
        }catch (NumberFormatException e) {
            value = toArabicNumber(symbol);
            alphabet = Alphabet.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception();
        }

        return new Number(value, alphabet);
    }

    static Number parseAndValidate(String symbol, Alphabet alphabet) throws Exception {

        Number number = parseAndValidate(symbol);
        if (number.getAlphabet() != alphabet) {
            throw new Exception();
        }

        return number;
    }

    private static int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry < Integer, String > entry: romanString.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String toRomanNumber(int number) {

        int i = romanString.floorKey(number);

        if (number == i) {
            return romanString.get(number);
        }
        return romanString.get(i) + toRomanNumber(number - i);
    }

    static int toArabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception();

            i++;
            if (i == roman.length()) {
                result += num;
            }else {
                int nextNum = letterToNumber(roman.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;
    }
}
