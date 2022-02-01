package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.ImageView;
import ankt;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends ImageView
{
  private RectF af = new RectF();
  private int bQd = ankt.dip2px(9.0F);
  private Rect be = new Rect();
  private boolean beX;
  private Bitmap dS;
  private Paint mPaint;
  private int mStrokeWidth = -1;
  private Matrix matrix = new Matrix();
  private int progress;
  private int ringColor = -9013368;
  private int ringWidth = 6;
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int k = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.dS != null) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.dS.getWidth(), this.dS.getHeight(), Bitmap.Config.ARGB_8888);
        if ((this.dS != null) && (localBitmap != null))
        {
          this.be.set(0, 0, this.dS.getWidth(), this.dS.getHeight());
          this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
          this.af.set(0.0F, 0.0F, j, k);
          j = this.progress * 360 / 100;
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(this.dS, null, this.be, null);
          localCanvas.drawArc(this.af, j - 90, 360 - j, true, this.mPaint);
          paramCanvas.drawBitmap(localBitmap, null, this.be, null);
          localBitmap.recycle();
          paramCanvas.restoreToCount(i);
          if (!this.beX) {}
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          ((ListenPanel)getParent().getParent()).Cv(201);
          this.beX = false;
          super.onDraw(paramCanvas);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          Object localObject1 = null;
          continue;
          if (this.mStrokeWidth > 0)
          {
            f = this.mStrokeWidth;
            this.af.set(this.bQd + f, this.bQd + f, j - f - this.bQd, k - f - this.bQd);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.ringWidth);
            this.mPaint.setColor(this.ringColor);
            j = this.progress * 360 / 100;
            paramCanvas.drawArc(this.af, 270.0F, j, false, this.mPaint);
            continue;
          }
          float f = 3.0F;
          continue;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOAudioPanel", 2, "CircleProgressView startPlayAnimByType error e=" + toString());
          }
          this.beX = false;
          continue;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void setAnimFlag(boolean paramBoolean)
  {
    this.beX = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
    invalidate();
  }
  
  public void setProgressBitmap(Bitmap paramBitmap)
  {
    this.dS = paramBitmap;
  }
  
  public void setRingColor(int paramInt)
  {
    this.ringColor = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.ringWidth = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */