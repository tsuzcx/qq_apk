package com.tencent.mobileqq.qzonevip.gift.particle;

import alsn;
import also;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleExplodeView
  extends ParticleTextureView
{
  public ParticleExplodeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float G(float paramFloat)
  {
    return (paramFloat - this.JO / 2) / 2.0F;
  }
  
  private Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int i = E(0, 3);
    if (i == 0) {
      return paramBitmap1;
    }
    if (i == 1) {
      return paramBitmap2;
    }
    return paramBitmap3;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int j = 0;
    if (j < paramInt1)
    {
      also localalso = new also();
      localalso.mBitmap = a(paramBitmap1, paramBitmap2, paramBitmap3);
      int i = 0;
      if (paramInt3 == 0) {
        i = E(0, 360);
      }
      for (;;)
      {
        double[] arrayOfDouble = a(paramInt2, i);
        localalso.mDx = ((float)(this.JO / 2 + arrayOfDouble[0]));
        localalso.mDy = ((float)(this.mViewHeight / 2 + arrayOfDouble[1]));
        localalso.mRotation = E(0, 360);
        this.yQ.add(localalso);
        j += 1;
        break;
        if (paramInt3 == 1) {
          i = E(0, 180);
        } else if (paramInt3 == 2) {
          i = E(180, 360);
        }
      }
    }
  }
  
  private double[] a(int paramInt1, int paramInt2)
  {
    return new double[] { paramInt1 * Math.cos(Math.toRadians(paramInt2)), paramInt1 * Math.sin(Math.toRadians(paramInt2)) };
  }
  
  private float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.JO / 2;
    float f2 = this.mViewHeight / 2;
    paramFloat2 = (f2 - paramFloat2) / (f1 - paramFloat1);
    return f2 + (paramFloat3 + paramFloat1) * paramFloat2 - f1 * paramFloat2;
  }
  
  protected int Ib()
  {
    return 20;
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length == 0) || (this.JO == 0) || (this.mViewHeight == 0))
    {
      QLog.e("ParticleExplodeView", 1, "updateData: bitmap = null error");
      return;
    }
    Object localObject = this.ae;
    Bitmap localBitmap1 = paramArrayOfBitmap[0];
    Bitmap localBitmap2 = paramArrayOfBitmap[1];
    paramArrayOfBitmap = paramArrayOfBitmap[2];
    try
    {
      a(5, this.JO / 40, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 20, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 10, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 7, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 5, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 4, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 3, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 2, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO / 2, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO * 3 / 5, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.JO * 3 / 5, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
      return;
    }
    finally {}
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { BitmapFactory.decodeResource(this.mContext.getResources(), 2130848993), BitmapFactory.decodeResource(this.mContext.getResources(), 2130848994), BitmapFactory.decodeResource(this.mContext.getResources(), 2130848995) };
  }
  
  protected boolean aut()
  {
    return false;
  }
  
  public void onStop()
  {
    this.mIsStop = true;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new alsn(this));
    localObjectAnimator.start();
  }
  
  protected void updateData()
  {
    for (;;)
    {
      float f2;
      synchronized (this.ae)
      {
        Iterator localIterator = this.yQ.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        also localalso = (also)localIterator.next();
        if (localalso == null) {
          continue;
        }
        f2 = G(localalso.mDx);
        if ((f2 > 0.0F) && (f2 < 5.0F))
        {
          f1 = 5.0F;
          localalso.mDy = e(localalso.mDx, localalso.mDy, f1);
          localalso.mDx = (f1 + localalso.mDx);
          localalso.mRotation += 15.0F;
          if ((localalso.mDx >= 0.0F) && (localalso.mDx <= this.JO) && (localalso.mDx != this.JO / 2)) {
            continue;
          }
          localIterator.remove();
        }
      }
      float f1 = f2;
      if (f2 > -5.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -5.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView
 * JD-Core Version:    0.7.0.1
 */