package hu.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private char[][] track;
    List<int[]> sign = new ArrayList<>();
    Turtle turt;

    public Map(int width, int height) {
        this.turt = new Turtle(width, height);
        this.track = new char[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.track[i][j] = '0';
            }
        }
    }


    public void drawer() {
        for (int i = 0; i < this.track.length; i++) {
            for (int j = 0; j < this.track[i].length; j++) {
                if (i == turt.getX() && j == turt.getY()) {
                    track[i][j] = '$';
                } else {
                    track[i][j] = '0';
                }
                for (int k = 0; k < sign.size(); k++) {
                    int[] arr = this.sign.get(k);
                    track[arr[0]][arr[1]] = '#';
                }
            }
        }

        for (char[] row : this.track) {
            System.out.println(Arrays.toString(row));
        }
    }


    public void doCommand(String dir) {
        if (dir.startsWith("J") || dir.startsWith("B") || dir.startsWith("L") || dir.startsWith("F")) {
            String[] direct = dir.split(" ");
            int mult = Integer.parseInt(direct[1]);
            for (int i = 0; i < mult; i++) {
                if (turt.isPen()) {
                    sign.add(new int[]{turt.getX(), turt.getY()});
                    turt.move(direct[0]);
                    drawer();
                } else {
                    turt.move(direct[0]);
                    drawer();
                }
            }
        } else if (dir.equals("TL")) {
            turt.setPen(false);
            drawer();
            sign.add(new int[]{turt.getX(), turt.getY()});
        } else if (dir.equals("TF")) {
            turt.setPen(true);
            drawer();
            sign.add(new int[]{turt.getX(), turt.getY()});
        } else if (dir.equals("K")) System.exit(0);
    }


    public char[][] getTrack() {
        return track;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
