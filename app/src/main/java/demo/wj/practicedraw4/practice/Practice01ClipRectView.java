package demo.wj.practicedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import demo.wj.practicedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Bitmap bt = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int sile = Math.min(w, h) / 2;
        bitmap = Bitmap.createScaledBitmap(bt,sile,sile,true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left =  bitmap.getWidth();
        int top = (getHeight() - bitmap.getHeight()) / 2;
        canvas.save();
        canvas.drawBitmap(bitmap,0,top,null);
        canvas.restore();
        canvas.save();
        canvas.clipRect(left,top+bitmap.getHeight()/4,left+bitmap.getWidth(),top+bitmap.getHeight()*3/4);
        canvas.drawBitmap(bitmap,bitmap.getWidth(),top,null);
        canvas.restore();


    }
}
