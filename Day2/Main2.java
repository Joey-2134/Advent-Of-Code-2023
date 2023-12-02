package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main2 {
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

            ArrayList<Integer> red = new ArrayList<>();
            ArrayList<Integer> blue = new ArrayList<>();
            ArrayList<Integer> green = new ArrayList<>();

            for (String s : splitAtComma) {
                String[] sSplit = s.split(",");
                for (String numColour : sSplit) {
                    String colour = numColour.replaceAll("\\d", "");
                    int val = Integer.parseInt(numColour.replaceAll("[^0-9]", ""));

                    switch (colour) {
                        case "red":
                            red.add(val);
                            break;
                        case "blue":
                            blue.add(val);
                            break;
                        case "green":
                            green.add(val);
                            break;
                    }
                }
            }
            sum += Collections.max(red) * Collections.max(green) * Collections.max(blue);
            i++;
        }
        System.out.println(sum);
    }

    private static void removeGame(int i, StringBuilder currline) {
        if (i <= 9) {
            currline.delete(0, 8);
        } else if (i >= 10 && i < 100) {
            currline.delete(0, 9);
        } else {
            currline.delete(0, 10);
        }
    }
}
