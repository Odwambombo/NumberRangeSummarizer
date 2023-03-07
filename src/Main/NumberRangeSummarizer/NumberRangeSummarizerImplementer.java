package NumberRangeSummarizer;

import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class NumberRangeSummarizerImplementer implements NumberRangeSummarizer {
    public static void main(String[] args) {
        Scanner myNumbers = new Scanner(System.in);
        System.out.println("Type your numbers and a comma after each number and press enter: ");
        String userInput = myNumbers.nextLine();
        NumberRangeSummarizerImplementer numbers = new NumberRangeSummarizerImplementer();
        System.out.println(numbers.summarizeCollection(numbers.collect(userInput)));
    }

    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> collection = new TreeSet<>();
        String[] inputValues = input.split(",");

        for (String inputValue : inputValues) {
            try {
                collection.add(Integer.parseInt(inputValue));
            } catch (NumberFormatException e) {
                System.out.println("Please insert only Integer values and type comma with no spaces in between!");
                throw e;
            }
        }
        return collection;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        StringBuilder finalString = new StringBuilder();
        int[] inputValue = input.stream().mapToInt(i -> i).toArray();

        int count = 0;
        int startOfSequentialValues = inputValue[0];
        String temp = "" + inputValue[0];
        int endOfSequentialValues = inputValue[0];

        for (int i = 0; i < inputValue.length - 1; i++) {
            if (inputValue[i + 1] == inputValue[i] + 1) {
                if (count == 0) {
                    startOfSequentialValues = inputValue[i];
                }
                endOfSequentialValues = inputValue[i + 1];
                count++;
            } else {
                if (count > 0) {
                    count = 0;
                    temp = startOfSequentialValues + "-" + endOfSequentialValues;
                }
                finalString.append(temp).append(", ");
                temp = "" + (inputValue[i + 1]);
            }
        }
        if (count > 0) {
            temp = startOfSequentialValues + "-" + endOfSequentialValues;
        }
        finalString.append(temp);
        return finalString.toString();
    }
}