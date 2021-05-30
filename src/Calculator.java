import java.util.Scanner;

public class Calculator {
        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                        System.out.println("Input: ");
                        String text = scanner.nextLine();

                        try {
                                String[] sign = text.split(" ");
                                if (sign.length != 3) throw new Exception();

                                Number a = NumberService.parseAndValidate(sign[0]);
                                Number b = NumberService.parseAndValidate(sign[2], a.getAlphabet());
                                String output = Action.calculate(a, b, sign[1]);
                                System.out.println("Output: \n" + output);

                        } catch (Exception e) {
                                e.printStackTrace();
                        }
        }
}


