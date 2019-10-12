package demo.wj.practicedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import demo.wj.practicedraw4.R;

public class Practice101MatrixPolyToPolyView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice101MatrixPolyToPolyView(Context context) {
        super(context);
    }

    public Practice101MatrixPolyToPolyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice101MatrixPolyToPolyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Matrix matrix = new Matrix();
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Bitmap bt = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int sile = w / 3;
        bitmap = Bitmap.createScaledBitmap(bt,sile,sile,true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sile = getWidth() / 3;
        int left = getWidth()/9;
        int top = (getHeight() - bitmap.getHeight()) /2;

        canvas.save();
        canvas.translate(left,top);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(left*2+sile,top);
        matrix.reset();
        float[] src = new float[]{0,0,bitmap.getWidth(),0,0,getHeight(),getWidth(),getHeight()};
        float[] dst = new float[]{0-10,50,bitmap.getWidth()+120,-90,0+20,getHeight()+30,getWidth()+20,getHeight()+60};
        matrix.setPolyToPoly(src,0,dst,0,4);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();
    }
}
