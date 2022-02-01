package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CaptureCircleProgress
  extends ImageView
{
  private PaintFlagsDrawFilter a;
  private Bitmap gc;
  private Bitmap gd;
  private int mHeight;
  private Paint mPaint;
  private int mProgress;
  private int mWidth;
  private Canvas o;
  
  public CaptureCircleProgress(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CaptureCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.a = new PaintFlagsDrawFilter(0, 3);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.gc == null) {
      return;
    }
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    if ((this.gd == null) || (this.mWidth != this.gd.getWidth()))
    {
      this.gd = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
      this.o = new Canvas(this.gd);
    }
    Object localObject = new Rect(0, 0, this.gc.getWidth(), this.gc.getHeight());
    Rect localRect = new Rect(0, 0, this.mWidth, this.mHeight);
    this.o.setDrawFilter(this.a);
    this.o.drawBitmap(this.gc, (Rect)localObject, localRect, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    localObject = new RectF(-30.0F, -30.0F, this.mWidth + 30, this.mHeight + 30);
    this.o.drawArc((RectF)localObject, -90.0F, -(float)(3.6D * (100 - this.mProgress)), true, this.mPaint);
    paramCanvas.setDrawFilter(this.a);
    paramCanvas.drawBitmap(this.gd, 0.0F, 0.0F, null);
    this.mPaint.setXfermode(null);
  }
  
  public void setProgress(int paramInt)
  {
    int i = 100;
    if (paramInt > 100) {}
    for (;;)
    {
      this.mProgress = i;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.mProgress = i;
      invalidate();
      return;
      i = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CaptureCircleProgress
 * JD-Core Version:    0.7.0.1
 */