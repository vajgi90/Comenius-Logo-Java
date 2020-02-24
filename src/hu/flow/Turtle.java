package hu.flow;

public class Turtle {
    private int x;
    private int y;
    private boolean pen;
    private int width;
    private int height;

    public Turtle(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.pen = false;
        this.width = width;
        this.height = height;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPen() {
        return pen;
    }

    public void setPen(boolean pen) {
        this.pen = pen;
    }

    public void move(String dir) {
        switch (dir) {
            case "L":
                if (this.x < this.height - 1) new OutOfTrackException("Out of track");
                ++this.x;
                break;
            case "F":
                if (this.x > 0) new OutOfTrackException("Out of track");
                --this.x;
                break;
            case "J":
                if (this.y < this.width - 1) new OutOfTrackException("Out of track");
                ++this.y;

                break;
            case "B":
                if (this.y > 0) new OutOfTrackException("Out of track");
                --this.y;

                break;
        }
    }


    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", pen=" + pen + "}";
    }
}



