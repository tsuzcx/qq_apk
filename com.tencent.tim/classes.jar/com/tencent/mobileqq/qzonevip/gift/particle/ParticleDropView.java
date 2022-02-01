package com.tencent.mobileqq.qzonevip.gift.particle;

import also;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleDropView
  extends ParticleTextureView
{
  private int bZm;
  private Bitmap mBitmap;
  
  public ParticleDropView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int Ib()
  {
    return 0;
  }
  
  public void a(also paramalso)
  {
    int j = 255;
    long l1 = System.currentTimeMillis() - paramalso.mStartPlayTime;
    long l2 = paramalso.mDuration;
    int i;
    if (l1 <= paramalso.mDuration / 4L)
    {
      i = (int)((float)(l1 - l2 / 4L) * 255.0F / (float)(l2 / 4L) + 255.0F);
      if (i <= 255) {
        break label159;
      }
      i = j;
    }
    label159:
    for (;;)
    {
      j = i;
      if (i < 0) {
        j = 0;
      }
      paramalso.mAlpha = j;
      return;
      if ((l1 >= paramalso.mDuration / 4L) && (l1 < paramalso.mDuration * 3L / 4L))
      {
        i = 255;
        break;
      }
      i = (int)((float)(l2 * 3L / 4L - l1) * 255.0F / (float)(l2 * 3L / 4L) + 255.0F);
      break;
    }
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    int i = 4;
    int j = 0;
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length == 0) || (this.JO == 0) || (this.mViewHeight == 0))
    {
      QLog.e("ParticleDropView", 1, "addData: bitmap = null error");
      return;
    }
    Bitmap localBitmap = paramArrayOfBitmap[0];
    this.bZm += 1;
    if (this.bZm < 3) {
      i = E(2, 4);
    }
    paramArrayOfBitmap = this.ae;
    for (;;)
    {
      if (j < i) {}
      also localalso;
      try
      {
        localalso = new also();
        localalso.mBitmap = localBitmap;
        localalso.mDuration = E(2000, 3500);
        localalso.mDx = (E(0, this.JO + 100) - 100);
        localalso.mDy = (E(0, this.mViewHeight * 4 / 5) - 200);
        localalso.mAlpha = 0;
        localalso.mScale = m(0.15F, 0.75F);
        localalso.mDy -= 300.0F;
        localalso.mRotation = E(0, 360);
        this.yQ.add(localalso);
        j += 1;
      }
      finally {}
    }
    if (this.bZm % 2 == 0)
    {
      localalso = new also();
      localalso.mBitmap = localBitmap;
      localalso.mDuration = E(2000, 3500);
      localalso.mDx = (E(0, this.JO + 100) - 100);
      localalso.mDy = (E(0, 100) - 300);
      localalso.mAlpha = 0;
      localalso.mRotation = E(0, 360);
      this.yQ.add(localalso);
    }
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { this.mBitmap };
  }
  
  protected boolean aut()
  {
    return (this.dwR % 40 == 0) && (!this.mIsStop);
  }
  
  public void onStart()
  {
    super.onStart();
    setAlpha(1.0F);
  }
  
  public void onStop()
  {
    super.onStop();
    synchronized (this.ae)
    {
      this.yQ.clear();
      return;
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  protected void updateData()
  {
    for (;;)
    {
      also localalso;
      synchronized (this.ae)
      {
        Iterator localIterator = this.yQ.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localalso = (also)localIterator.next();
        if (localalso == null) {
          continue;
        }
        if (localalso.mScale > 0.75F)
        {
          localalso.mDy += 13.0F;
          if (!localalso.czd)
          {
            localalso.dwQ = E(-1, 1);
            localalso.czd = true;
          }
          if (localalso.dwQ == 0) {
            localalso.dwQ = 1;
          }
          localalso.mDx += localalso.dwQ;
          a(localalso);
          if ((localalso.mAlpha != 0) && (localalso.mDy < this.mViewHeight)) {
            continue;
          }
          localIterator.remove();
        }
      }
      localalso.mDy += 8.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView
 * JD-Core Version:    0.7.0.1
 */