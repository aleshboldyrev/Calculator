public class Action {
    public static String calculate(Number first, Number second, String action) throws Exception {
        int result;

        switch (action) {
            case "+":
                result = first.getNumber() + second.getNumber();
                break;
            case "-":
                result = first.getNumber() - second.getNumber();
                break;
            case "*":
                result = first.getNumber() * second.getNumber();
                break;
            case "/":
                result = first.getNumber() / second.getNumber();
                break;
            default:
                throw new Exception();
        }
        if (first.getAlphabet() == Alphabet.ROMAN) {
            return Service.toRoman(result);
        } else return String.valueOf(result);
    }
}
