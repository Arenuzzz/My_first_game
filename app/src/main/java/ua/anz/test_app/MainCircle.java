package ua.anz.test_app;

/**
 * Created by AreNuZzz on 17.12.2015.
 */
public class MainCircle {
    public static final int RADIUS = 50;
    private int x;
    private int y;
    private int radius;

    public MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        radius = RADIUS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}