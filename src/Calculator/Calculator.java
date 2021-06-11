package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String text = sc.nextLine();

        String[] sign = text.split(" ");
        if (sign.length != 3) throw new Exception();
        Number first = Service.parseAndValidate(sign[0]);
        Number second = Service.parseAndValidate(sign[2], first.getAlphabet());
        String result = Action.calculate(first, second, sign[1]);
        System.out.println("Output: \n" + result);
    }
}
