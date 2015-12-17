package ua.anz.test_app;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by AreNuZzz on 17.12.2015.
 */
public class GameManager {

    private MainCircle mainCircle;
    private Paint paint;
    private  static int width;
    private  static int height;
    private CanvasView canvasView;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initPaint();



    }
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width/2,height/2);

    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(),mainCircle.getRadius(),paint);

    }
}
