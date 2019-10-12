package demo.wj.practicedraw4.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import demo.wj.practicedraw4.R;

public class Practice14FlipboardView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    public Practice14FlipboardView(Context context) {
        super(context);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Bitmap bt = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int sile = w / 3;
        bitmap = Bitmap.createScaledBitmap(bt, sile, sile, true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sile = getWidth() / 3;
        int left = getWidth() / 9;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        canvas.save();
        canvas.translate(left, top);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(left, top);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(left * 2 + sile, top);

        canvas.save();
        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        camera.save(); // 保存 Camera 的状态
        camera.rotateX(degree);
        canvas.translate(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        camera.applyToCanvas(canvas);
        canvas.translate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
        camera.restore(); // 恢复 Camera 的状态
        canvas.clipRect(0, bitmap.getHeight() / 2, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.restore();
    }
}
