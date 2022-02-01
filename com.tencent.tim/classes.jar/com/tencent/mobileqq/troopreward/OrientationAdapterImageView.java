package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import apze;
import com.tencent.qphone.base.util.QLog;

public class OrientationAdapterImageView
  extends View
{
  protected RectF aT = new RectF();
  public int che = 1;
  public Bitmap gA;
  protected Handler mHandler = new apze(this);
  protected Paint mPaint;
  
  public OrientationAdapterImageView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public OrientationAdapterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  protected void a(RectF paramRectF, Bitmap paramBitmap, View paramView)
  {
    int i = paramView.getHeight();
    int j = paramView.getWidth();
    int k = paramBitmap.getHeight();
    int m = paramBitmap.getWidth();
    paramRectF.set(0.0F, 0.0F, j, i);
    float f1 = j * 1.0F / i;
    float f2 = m * 1.0F / k;
    if (QLog.isColorLevel()) {
      QLog.d("OrientationAdapterImageView", 2, "getTargetRectF,  viewRatio:" + f1 + ", bmpRatio:" + f2 + ", mOrientation:" + this.che);
    }
    int n;
    if ((this.che == 0) || (this.che == 180)) {
      if (f1 > f2)
      {
        n = (int)(m * 1.0F * i / k);
        m = (j - n) / 2;
        k = 0;
        j = n + m;
      }
    }
    for (;;)
    {
      paramRectF.set(m, k, j, i);
      if (QLog.isColorLevel()) {
        QLog.d("OrientationAdapterImageView", 2, "getTargetRectF:" + paramRectF.toString());
      }
      return;
      n = (int)(k * 1.0F * j / m);
      m = 0;
      k = (i - n) / 2;
      i = k + n;
      continue;
      if (f1 > f2)
      {
        n = (int)(j * f2);
        m = (j - n) / 2;
        k = (i - j) / 2;
        n += m;
        i = k + j;
        j = n;
      }
      else
      {
        m = -((int)(j * f2) - j) / 2;
        k = (i - j) / 2;
        n = j - m;
        i = k + j;
        j = n;
      }
    }
  }
  
  protected void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    setBackgroundColor(-16777216);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.gA != null)
    {
      a(this.aT, this.gA, this);
      paramCanvas.save();
      paramCanvas.rotate(this.che, getWidth() / 2, getHeight() / 2);
      paramCanvas.drawBitmap(this.gA, null, this.aT, this.mPaint);
      paramCanvas.restore();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.gA = paramBitmap;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopreward.OrientationAdapterImageView
 * JD-Core Version:    0.7.0.1
 */