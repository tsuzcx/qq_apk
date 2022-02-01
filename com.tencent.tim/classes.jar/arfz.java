import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

public class arfz
  extends Drawable
{
  public static int STATE_NORMAL;
  private PorterDuffXfermode b = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  private ValueAnimator d;
  private int efI = -872415232;
  private int efJ = 0;
  public int egt = Color.argb(255, 137, 208, 67);
  public int egu = Color.argb(255, 255, 66, 34);
  private int egv = Color.argb(127, 255, 255, 255);
  private int mAlpha;
  private int mCircleRadius;
  private Paint mPaint = new Paint();
  private int mProgress = -1;
  private int mState;
  private int mStrokeWidth;
  
  private void Yz(int paramInt)
  {
    if ((this.d != null) && (this.d.isRunning()) && (paramInt == 7)) {
      this.d.cancel();
    }
  }
  
  private void startAnimation()
  {
    this.d = ValueAnimator.ofInt(new int[] { 0, 100 });
    this.d.addUpdateListener(new arga(this));
    this.d.setDuration(3000L);
    this.d.setInterpolator(new LinearInterpolator());
    this.d.start();
  }
  
  public void Yr(int paramInt)
  {
    this.mCircleRadius = paramInt;
  }
  
  public void Yy(int paramInt)
  {
    if (this.mState != paramInt)
    {
      this.mState = paramInt;
      if (this.mState == 6) {
        startAnimation();
      }
    }
    else
    {
      return;
    }
    Yz(this.mState);
    this.mProgress = -1;
    invalidateSelf();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = getBounds();
    paramCanvas.save();
    int j = ((Rect)localObject).centerX();
    int k = ((Rect)localObject).centerY();
    int m = this.mCircleRadius;
    paramCanvas.clipRect((Rect)localObject);
    paramCanvas.drawColor(this.efI);
    int i;
    if (this.mState > STATE_NORMAL)
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(this.efJ);
      this.mPaint.setXfermode(this.b);
      paramCanvas.drawCircle(j, k, m, this.mPaint);
      if (this.mState > 1)
      {
        i = this.egt;
        switch (this.mState)
        {
        }
      }
    }
    for (;;)
    {
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setXfermode(null);
      this.mPaint.setColor(i);
      this.mPaint.setStrokeWidth(this.mStrokeWidth);
      paramCanvas.drawCircle(j, k, m, this.mPaint);
      if (this.mProgress != -1)
      {
        localObject = new RectF(j - m, k - m, j + m, k + m);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setXfermode(null);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        paramCanvas.drawArc((RectF)localObject, 270.0F, this.mProgress / 100.0F * 360.0F, false, this.mPaint);
      }
      paramCanvas.restore();
      return;
      i = -1;
      continue;
      i = this.egt;
      continue;
      i = this.egu;
      continue;
      i = this.egv;
    }
  }
  
  public int getOpacity()
  {
    return this.mAlpha;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfz
 * JD-Core Version:    0.7.0.1
 */