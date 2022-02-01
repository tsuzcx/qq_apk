package com.tencent.mobileqq.portal;

import akzv;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import aqnc;

public class ImageShakeAnimView
  extends View
{
  aqnc<Float> a = null;
  Rect co = new Rect();
  public boolean cvx = false;
  int dqE = 0;
  int dqF = 0;
  Bitmap eM;
  int height = 0;
  public Transformation mTransformation = new Transformation();
  int width = 0;
  public float ym = 1.0F;
  public float yn = 1.0F;
  
  public ImageShakeAnimView(Context paramContext)
  {
    super(paramContext);
    n(null);
  }
  
  public ImageShakeAnimView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Integer paramInteger, boolean paramBoolean)
  {
    super(paramContext);
    n(paramInteger);
    this.width = paramInt1;
    this.height = paramInt2;
    this.dqE = paramInt3;
    this.dqF = paramInt4;
    this.cvx = paramBoolean;
  }
  
  public ImageShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    n(null);
  }
  
  private void n(Integer paramInteger)
  {
    try
    {
      this.eM = PortalManager.i("", true);
      return;
    }
    catch (OutOfMemoryError paramInteger)
    {
      paramInteger.printStackTrace();
    }
  }
  
  public boolean d(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.eM == null) {}
    do
    {
      return false;
      if (this.width == 0)
      {
        this.width = getWidth();
        this.height = getHeight();
      }
      paramCanvas.save();
      paramCanvas.translate(this.dqE, this.dqF);
      paramCanvas.scale(this.ym, this.yn, this.width / 2, 0.0F);
      this.co.set(0, 0, this.width, this.width * this.eM.getHeight() / this.eM.getWidth());
      paramCanvas.drawBitmap(this.eM, null, this.co, null);
      paramCanvas.restore();
    } while (this.a == null);
    return this.a.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.mTransformation);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (d(paramCanvas)) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.cvx)
    {
      this.width = getWidth();
      this.height = getHeight();
    }
  }
  
  public void startAnim()
  {
    float f;
    aqnc localaqnc;
    if (this.cvx)
    {
      f = 720.0F;
      localaqnc = new aqnc(Float.valueOf(0.0F), Float.valueOf(f), new akzv(this));
      if (this.a != null) {
        this.a.cancel();
      }
      this.a = localaqnc;
      if (!this.cvx) {
        break label88;
      }
    }
    label88:
    for (long l = 720L;; l = 500L)
    {
      localaqnc.setDuration(l);
      localaqnc.start();
      invalidate();
      return;
      f = 500.0F;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageShakeAnimView
 * JD-Core Version:    0.7.0.1
 */