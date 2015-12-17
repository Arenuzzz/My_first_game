package ua.anz.test_app;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by AreNuZzz on 17.12.2015.
 */
public class GameManager {

    private MainCircle mainCircle;
    private Paint paint;

    public GameManager() {
        initMainCircle();
        initPaint();
    }
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(200,500);

    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(),mainCircle.getRadius(),paint);

    }
}
