package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CircleGuideView
  extends View
{
  private int backgroundAlpha = 180;
  private Bitmap fe;
  private float hG;
  private Paint mPaint = new Paint();
  private Canvas n = new Canvas();
  private float vJ;
  private float vK;
  
  public CircleGuideView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CircleGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint.setARGB(0, 0, 0, 0);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.mPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.fe == null) {}
    try
    {
      this.fe = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
      this.n.setBitmap(this.fe);
      if (this.fe != null)
      {
        this.n.drawColor(Color.argb(this.backgroundAlpha, 0, 0, 0));
        this.n.drawCircle(this.vJ, this.vK, this.hG, this.mPaint);
        paramCanvas.drawBitmap(this.fe, new Rect(0, 0, this.fe.getWidth(), this.fe.getHeight()), new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight()), null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleGuideView", 2, localThrowable.toString());
        }
      }
      paramCanvas.drawColor(Color.argb(this.backgroundAlpha, 0, 0, 0));
    }
  }
  
  public void setCircle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.vJ = paramFloat1;
    this.vK = paramFloat2;
    this.hG = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.CircleGuideView
 * JD-Core Version:    0.7.0.1
 */