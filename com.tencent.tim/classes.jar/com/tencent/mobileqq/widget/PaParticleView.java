package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import argn;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  ArrayList<Bitmap> Dm;
  ArrayList<argn> Dn;
  int egV;
  int egW;
  public int mFrameHeight;
  public int mFrameWidth;
  public int mMinHeight;
  public int mOffset;
  protected Paint mPaint;
  protected int mSleepTime;
  Random random = new Random();
  
  public PaParticleView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext);
    this.egV = paramInt1;
    this.egW = paramInt2;
    this.Dm = new ArrayList();
    this.Dn = new ArrayList(this.egW);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setAlpha(paramInt5);
    this.mSleepTime = paramInt4;
    this.mOffset = paramInt3;
  }
  
  private void a(argn paramargn)
  {
    if (this.mMinHeight == 0) {
      if ((paramargn.x > this.mFrameWidth) || (paramargn.y > this.mFrameHeight)) {
        paramargn.y = 0.0F;
      }
    }
    for (paramargn.x = (this.random.nextFloat() * this.mFrameWidth);; paramargn.x = (this.random.nextFloat() * this.mFrameWidth))
    {
      do
      {
        paramargn.x += paramargn.offset;
        paramargn.y += paramargn.speed;
        return;
      } while ((paramargn.x <= this.mFrameWidth) && (paramargn.y >= this.mMinHeight));
      paramargn.y = this.mFrameHeight;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.Dn != null) && (this.Dn.size() >= this.egW))
    {
      int i = 0;
      while (i < this.egW)
      {
        argn localargn = (argn)this.Dn.get(i);
        a(localargn);
        paramCanvas.drawBitmap(localargn.bitmap, localargn.x, localargn.y, this.mPaint);
        i += 1;
      }
    }
    postInvalidateDelayed(this.mSleepTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaParticleView
 * JD-Core Version:    0.7.0.1
 */