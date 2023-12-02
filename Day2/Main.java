package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("./Day2/input.txt");
        Scanner scanner = new Scanner(input);
        StringBuilder currline;
        int i = 1;
        int sum = 0;

        while (scanner.hasNextLine()) {
            currline = new StringBuilder(scanner.nextLine());

            removeGame(i, currline);
            String currlineAsString = currline.toString();
            currlineAsString = currlineAsString.replace(" ", "");
            String[] splitAtComma = currlineAsString.split(";");

            boolean flag = true;
            for (String s : splitAtComma) {
                String[] sSplit = s.split(",");
                for (String numColour : sSplit) {
                    if (Character.isDigit(numColour.charAt(1))) {
                        String num = numColour.substring(0,2);
                        String colour = numColour.substring(2);

                        switch (colour) {
                            case "red":
                                if (Integer.parseInt(num) > 12) {
                                    flag = false;
                                }
                                break;

                            case "blue":
                                if (Integer.parseInt(num) > 14) {
                                    flag = false;
                                }
                                break;

                            case "green":
                                if (Integer.parseInt(num) > 13) {
                                    flag = false;
                                }
                                break;
                        }
                    }
                }
            }
            if (flag) sum += i;
            System.out.println(sum);
            i++;
        }

    }

    private static void removeGame(int i, StringBuilder currline) {
        if (i <= 9) {
            currline.delete(0,8);
        } else if (i >= 10 && i < 100) {
            currline.delete(0,9);
        } else {
            currline.delete(0,10);
        }
    }
}
