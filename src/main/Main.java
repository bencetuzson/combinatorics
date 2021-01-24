package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.model.Combinatorics;
import org.jetbrains.annotations.NotNull;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input;
    private static int n;
    private static int[] k;
    private static int result;

    public static void main(String[] args) throws IOException {

        ask("Do you have to select all the numbers?");
        switch (input) {
            case "y" -> {
                ask("Is there any items that are the same?");
                switch (input) {
                    case "y" -> {System.out.println("Permutation with repetition");nIn();kArrIn();}
                    case "n" -> {System.out.println("Permutation without repetition");nIn();result = Integer.parseInt(String.valueOf(Combinatorics.factorial(n)));print();}
                }
            }
            case "n" -> {
                ask("Does the items' order matter?");
                switch (input) {
                    case "y" -> {
                        ask("Can any of the items be multiple times during selection?");
                        switch (input) {
                            case "y" -> {System.out.println("Variation with repetition");nIn();kIn();result = Combinatorics.nPr(n, k[0]);print();}
                            case "n" -> {System.out.println("Variation without repetition");nIn();}
                        }
                    }
                    case "n" -> {
                        ask("Can an item be multiple times during selection?");
                        switch (input) {
                            case "y" -> {System.out.println("Combination with repetition");nIn();kIn();result = Combinatorics.nCr(n, k[0]);print();}
                            case "n" -> {System.out.println("Combination without repetition");nIn();}
                        }
                    }
                }
            }
        }

    }

    public static boolean isValid() {
        return
            switch (input) {
                case "y", "n" -> false;
                default -> {
                    if (!input.equals("")) {
                        System.err.println("Invalid parameter, try again!");
                    }
                    yield true;
                }
            }
        ;
    }

    public static boolean isNumber() {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            if (!input.equals("")) {
                System.err.println("Invalid parameter, try again!");
            }
            return true;
        }

    }

    public static boolean isNumberArr() {
        try {
            String[] raw = input.split(" ");
            for (String num : raw) {
                Integer.parseInt(num);
            }
            return false;
        } catch (NumberFormatException e) {
            if (!input.equals("")) {
                System.err.println("Invalid parameter, try again!");
            }
            return true;
        }

    }

    public static void ask(String print) throws IOException {
        modeInput(print + " (y/n)");
    }

    public static void kArrIn() throws IOException {
        do {
            numArrInput("Enter values of K! (separated with space)");
            k = toArray(input);
            if (k[0] < n || k[0] <= 0) {
                System.err.println("Value must be positive!");
            }
        } while (k[0] < 0);

    }

    public static void kIn() throws IOException {
        do {
            numArrInput("Enter value of K!");
            k = new int[]{Integer.parseInt(input)};
            if (k[0] <= 0) {
                System.err.println("Value must be positive!");
            }
        } while (k[0] <= 0);


    }

    public static void nIn() throws IOException {
        do {
            numInput("Enter value of N!");
            n = Integer.parseInt(input);
            if (n <= 0) {
                System.err.println("Value must be positive!");
            }
        } while (n <= 0);
    }

    public static void input() throws IOException {
        input = reader.readLine();
    }

    public static void modeInput(String print) throws IOException {
        System.out.println(print);
        do {
            input();
        } while (isValid());
    }

    public static void numInput(String print) throws IOException {
        System.out.println(print);
        do {
            input();
        } while (isNumber());
    }

    public static void numArrInput(String print) throws IOException {
        System.out.println(print);
        do {
            input();
        } while (isNumberArr());
    }

    public static void input(String print) throws IOException {
        System.out.println(print);
        input();
    }

    public static int @NotNull [] toArray(String in) {
        int i = 0;
        int[] ret = new int[in.split(" ").length];
        String[] raw = in.split(" ");
        for (String num : raw) {
            ret[i] = Integer.parseInt(num);
            ++i;
        }
        return ret;
    }

    public static void print() {
        System.out.println("Result: " + result);
    }


}
