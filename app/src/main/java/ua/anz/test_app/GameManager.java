package ua.anz.test_app;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by AreNuZzz on 17.12.2015.
 */
public class GameManager {

    private MainCircle mainCircle;

    private  static int width;
    private  static int height;
    private CanvasView canvasView;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    private void initMainCircle() {
        mainCircle = new MainCircle(width/2,height/2);

    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);

    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleOnTouchEvent(x,y);
    }
}
