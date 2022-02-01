package com.tencent.mobileqq.portal;

import akzu;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import aqnc;

public class ImageAlphaSwitchView
  extends View
{
  public aqnc<Float> a = null;
  public float alpha = 0.0F;
  private Rect co = new Rect();
  int dqD = 3;
  public Bitmap fG;
  public Bitmap fH;
  int height;
  Paint mPaint = new Paint();
  public Transformation mTransformation = new Transformation();
  int width;
  
  public ImageAlphaSwitchView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setAntiAlias(true);
  }
  
  public ImageAlphaSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setAntiAlias(true);
  }
  
  private void startAnim()
  {
    aqnc localaqnc = new aqnc(Float.valueOf(0.0F), Float.valueOf(255.0F), new akzu(this));
    if (this.a != null) {
      this.a.cancel();
    }
    this.a = localaqnc;
    localaqnc.setDuration(500L);
    localaqnc.start();
    invalidate();
  }
  
  public void Z(Bitmap paramBitmap)
  {
    if (this.fG == null)
    {
      this.fG = paramBitmap;
      this.fH = null;
      this.alpha = 0.0F;
      invalidate();
      return;
    }
    this.fH = paramBitmap;
    startAnim();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = false;
    super.onDraw(paramCanvas);
    this.width = getWidth();
    this.height = getHeight();
    int i;
    int m;
    int j;
    if (this.fH != null)
    {
      i = this.fH.getWidth();
      k = this.fH.getHeight();
      m = this.height * i / k;
      j = this.height;
      if (m <= this.width) {
        break label415;
      }
      m = this.width;
      j = m * k / i;
    }
    label404:
    label410:
    label415:
    for (int k = (this.height - j) / 2;; k = 0)
    {
      if (this.dqD == 3) {
        i = 0;
      }
      for (;;)
      {
        this.mPaint.setAlpha((int)this.alpha);
        this.co.set(i, k, m + i, j);
        paramCanvas.drawBitmap(this.fH, null, this.co, this.mPaint);
        if (this.fG != null)
        {
          i = this.fG.getWidth();
          k = this.fG.getHeight();
          m = this.height * i / k;
          j = this.height;
          if (m <= this.width) {
            break label404;
          }
          m = this.width;
          j = this.width * k / i;
        }
        for (k = (this.height - j) / 2;; k = 0)
        {
          if (this.dqD == 3) {
            i = 0;
          }
          for (;;)
          {
            this.mPaint.setAlpha(255 - (int)this.alpha);
            this.co.set(i, k, m + i, j);
            paramCanvas.drawBitmap(this.fG, null, this.co, this.mPaint);
            if (this.a != null) {
              bool = this.a.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mTransformation);
            }
            if (bool) {
              invalidate();
            }
            return;
            if (this.dqD == 17)
            {
              i = (this.width - m) / 2;
              break;
            }
            if (this.dqD != 5) {
              break label410;
            }
            i = this.width - m;
            break;
            if (this.dqD == 17) {
              i = (this.width - m) / 2;
            } else if (this.dqD == 5) {
              i = this.width - m;
            } else {
              i = 0;
            }
          }
        }
        i = 0;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGravity(int paramInt)
  {
    this.dqD = paramInt;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.cancel();
    }
    this.fG = paramBitmap;
    this.fH = null;
    this.alpha = 0.0F;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView
 * JD-Core Version:    0.7.0.1
 */