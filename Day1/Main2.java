package Day1;/*
    Author: Joey Galvin
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("./Day1/input.txt");
        Scanner scanner = new Scanner(input);

        HashMap<String, String> stringToNumMap = new HashMap<>();
        stringToNumMap.put("one", "o1e");
        stringToNumMap.put("two", "t2o");
        stringToNumMap.put("three", "thr3ee");
        stringToNumMap.put("four", "fo4r");
        stringToNumMap.put("five", "fi5e");
        stringToNumMap.put("six", "s6x");
        stringToNumMap.put("seven", "se7en");
        stringToNumMap.put("eight", "ei8ht");
        stringToNumMap.put("nine", "n9ne");

        String currLine = "";
        int sum = 0;

        while(scanner.hasNextLine()) {

            String concatNum = "";
            currLine = scanner.nextLine();

            for (Map.Entry<String, String> entry : stringToNumMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (currLine.contains(key)) {
                    currLine = currLine.replace(key,value);
                }
            }

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
        scanner.close();
    }
}