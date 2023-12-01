package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("./Day1/input.txt");
        Scanner scanner = new Scanner(input);

        String currLine = "";
        int sum = 0;

        while(scanner.hasNextLine()) {

            String concatNum = "";
            currLine = scanner.nextLine();

            for (int i = 0; i < currLine.length(); i++) {
                if (Character.isDigit(currLine.charAt(i))) {
                    concatNum += currLine.charAt(i);
                    for (int j = currLine.length()-1; j >= 0; j--) {
                        if (Character.isDigit(currLine.charAt(j))) {
                            concatNum += currLine.charAt(j);
                            break;
                        }
                    }
                    break;
                }
            }
            sum += Integer.parseInt(concatNum);
        }
        System.out.println(sum);
    }
}