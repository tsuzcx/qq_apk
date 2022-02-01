package com.tencent.mobileqq.portal;

import alae;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import java.util.ArrayList;
import wja;

public class SanHuaView
  extends View
{
  Matrix N = new Matrix();
  boolean cvD = false;
  int dqV;
  int height;
  private Bitmap[] mBitmaps = new Bitmap[this.mu.length];
  Resources mRes = getResources();
  private int[] mu = { 2130846181, 2130846182, 2130846183, 2130846184, 2130846185, 2130846186, 2130846187, 2130846188 };
  long startTime;
  int width;
  ArrayList<alae> yB = new ArrayList();
  float yp;
  float yq;
  
  public SanHuaView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.yp = paramInt1;
    this.yq = paramInt2;
    paramInt1 = i;
    try
    {
      while (paramInt1 < this.mBitmaps.length)
      {
        this.mBitmaps[paramInt1] = BitmapFactory.decodeResource(this.mRes, this.mu[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void SC(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(this.mBitmaps.length * Math.random());
      if (this.mBitmaps[j] != null) {
        this.yB.add(alae.a(this.mBitmaps[j], this.yp, this.yq, this.mRes));
      }
      i += 1;
    }
    this.dqV += paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.cvD) {}
    do
    {
      return;
      super.onDraw(paramCanvas);
      float f1 = (float)(System.currentTimeMillis() - this.startTime) / 1000.0F;
      int i = 0;
      alae localalae;
      if (i < this.dqV)
      {
        localalae = (alae)this.yB.get(i);
        if (localalae == null) {}
        for (;;)
        {
          i += 1;
          break;
          float f2;
          float f3;
          float f4;
          if (localalae.angle < 0.0D)
          {
            f2 = localalae.qB;
            f3 = localalae.qC;
            f4 = wja.dp2px(270.0F, this.mRes);
            localalae.cT[0] = (this.yp - f2 * f1);
            localalae.cT[1] = (this.yq + (f3 * f1 + f4 * 0.5F * f1 * f1));
          }
          else
          {
            f2 = localalae.qB;
            f3 = localalae.qC;
            f4 = wja.dp2px(270.0F, this.mRes);
            localalae.cT[0] = (f2 * f1 + this.yp);
            localalae.cT[1] = (this.yq - (f3 * f1 - f4 * 0.5F * f1 * f1));
          }
        }
      }
      i = 0;
      int j = 0;
      if (i < this.dqV)
      {
        localalae = (alae)this.yB.get(i);
        int k;
        if (localalae == null) {
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (localalae.cT[0] < this.width)
          {
            k = j;
            if (localalae.cT[0] > 0.0F)
            {
              k = j;
              if (localalae.cT[1] < this.height)
              {
                k = j;
                if (localalae.cT[1] > 0.0F)
                {
                  this.N.setTranslate(-localalae.width / 2, -localalae.height / 2);
                  this.N.postRotate(localalae.rotation);
                  this.N.postTranslate(localalae.width / 2 + localalae.cT[0], localalae.height / 2 + localalae.cT[1]);
                  paramCanvas.drawBitmap(localalae.bitmap, this.N, null);
                  k = j + 1;
                }
              }
            }
          }
        }
      }
      if (j == 0) {
        stopAnimation();
      }
    } while (!this.cvD);
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void startAnimation()
  {
    this.cvD = true;
    this.startTime = System.currentTimeMillis();
    invalidate();
  }
  
  public void stopAnimation()
  {
    this.cvD = false;
    this.yB.clear();
    this.dqV = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHuaView
 * JD-Core Version:    0.7.0.1
 */