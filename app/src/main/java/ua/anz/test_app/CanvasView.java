package ua.anz.test_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by AreNuZzz on 15.12.2015.
 */
public class CanvasView extends View implements ICanvasView{
    private GameManager gameManager;
    private  static int width;
    private  static int height;
    private Paint paint;
    private Canvas canvas;
    private Toast toast;
    
    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWidthAndHeight(context);
        initPaint();
        gameManager = new GameManager(this,width,height);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initWidthAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display display =  windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();

    }


    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public void reDraw() {
        invalidate();
    }

    @Override
    public void showMessage(String text) {
        if(toast != null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(getContext(),text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            gameManager.onTouchEvent(x,y);
        }
        invalidate();
            return  true;
    }
    
//Доработать
    public static int reCalculateRadius(int redius)
    {
        return redius * 768 / width < height ? width : height;
    }
}
