public class Service {
    private final static int[] arabian = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    private final static String[] romanian = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    static Number parseAndValidate(String sign) throws Exception {
        int value;
        Alphabet alphabet;

        try {
            value = Integer.parseInt(sign);
            alphabet = Alphabet.ARAB;
        } catch (Exception e) {
            value = toArabic(sign);
            alphabet = Alphabet.ROMAN;
        }
        if (value < 1 || value > 10) {
            throw new Exception();
        }
        return new Number(value, alphabet);
    }

    static Number parseAndValidate(String sign, Alphabet alphabet) throws Exception {

        Number number = parseAndValidate(sign);
        if (number.getAlphabet() != alphabet) {
            throw new Exception();
        }
        return number;
    }


    private static int findFloor(final int number, final int firstIndex, final int lastIndex) {
        if (firstIndex == lastIndex)
            return firstIndex;
        if (arabian[firstIndex] == number)
            return firstIndex;
        if (arabian[lastIndex] == number)
            return lastIndex;
        final int median = (lastIndex + firstIndex) / 2;
        if (median == firstIndex)
            return firstIndex;
        if (number == arabian[median])
            return median;
        if (number > arabian[median])
            return findFloor(number, median, lastIndex);
        else
            return findFloor(number, firstIndex, median);

    }

    public static String toRoman(final int number) {
        int floorIndex = findFloor(number, 0, arabian.length - 1);
        if (number == arabian[floorIndex])
            return romanian[floorIndex];
        return romanian[floorIndex] + toRoman(number - arabian[floorIndex]);
    }

    public static int toArabic(String roman) {
        int result = 0;
        for (int i = arabian.length - 1; i >= 0; i--) {
            while (roman.indexOf(romanian[i]) == 0 && romanian[i].length() > 0) {
                result += arabian[i];
                roman = roman.substring(romanian[i].length());
            }
        }
        return result;
    }
}
