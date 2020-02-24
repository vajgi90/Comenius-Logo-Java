package hu.flow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map game = new Map(10, 10);
        try {
            String x = sc.nextLine();
            game.drawer();
            while (!x.equals("K")) {
                game.doCommand(x);
                x = sc.nextLine();
            }
        } catch (OutOfTrackException e) {
            System.out.println("Valami besült");
        }
    }
}



