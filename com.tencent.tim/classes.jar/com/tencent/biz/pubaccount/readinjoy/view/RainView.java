package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anyb;
import anyc;
import anye;
import anyu;
import anyv;
import aqcx;
import aqhu;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import ndf;
import ndg;

public class RainView
  extends SpriteGLView
  implements Runnable
{
  private static int DELAY_TIME = 200;
  private static int aXV = 4000;
  private static int aXW = 100;
  private static int aXX = 3;
  private static int aXY = 6;
  private anyv jdField_a_of_type_Anyv;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView$a;
  private int aXZ;
  private int aYa;
  private AtomicInteger aa;
  private int mBottom;
  private Context mContext;
  private AtomicInteger mCount;
  private int mHeight;
  private int mTop;
  
  public RainView(Context paramContext)
  {
    super(paramContext, 1);
    this.mContext = paramContext;
    this.cKI = false;
    this.aa = new AtomicInteger(0);
  }
  
  private int dz(int paramInt)
  {
    switch (new Random().nextInt(5))
    {
    default: 
      return paramInt;
    case 0: 
      return (int)(paramInt - this.mHeight * Math.tan(0.174532925199433D));
    case 1: 
      return (int)(paramInt - this.mHeight * Math.tan(0.349065850398866D));
    case 2: 
      return (int)(paramInt + this.mHeight * Math.tan(0.174532925199433D));
    }
    return (int)(paramInt + this.mHeight * Math.tan(0.349065850398866D));
  }
  
  private Bitmap r(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()))
    {
      paramString = null;
      return paramString;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    aqhu.d(paramString, (BitmapFactory.Options)localObject);
    int m = ((BitmapFactory.Options)localObject).outHeight;
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = aqcx.dip2px(getContext(), 80.0F);
    int k = aqcx.dip2px(getContext(), 80.0F);
    if ((m > j) || (i > k))
    {
      m /= 2;
      int n = i / 2;
      i = 2;
      while ((m / i >= j) && (n / i >= k)) {
        i *= 2;
      }
      j = i;
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "inSampleSize = " + i);
      }
    }
    for (j = i;; j = 1) {
      for (;;)
      {
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject).inSampleSize = j;
        ((BitmapFactory.Options)localObject).inTargetDensity = this.mContext.getResources().getDisplayMetrics().densityDpi;
        ((BitmapFactory.Options)localObject).inDensity = 320;
        ((BitmapFactory.Options)localObject).inScaled = true;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        try
        {
          localObject = aqhu.d(paramString, (BitmapFactory.Options)localObject);
          paramString = (String)localObject;
          if (localObject != null) {
            break;
          }
          QLog.e("SpriteGLView", 1, "getPngDrawable bitmap = null");
          return null;
        }
        catch (OutOfMemoryError paramString)
        {
          QLog.e("SpriteGLView", 1, "getPngDrawable oom = " + paramString);
          return null;
        }
      }
    }
  }
  
  public void k(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i = this.aa.incrementAndGet();
    if (i == 1)
    {
      paramString = r(paramString);
      if (paramString != null) {
        this.jdField_a_of_type_Anyv = new anyv(this, paramString);
      }
      if (this.jdField_a_of_type_Anyv != null)
      {
        this.aXZ = (paramInt1 / aXX);
        this.mTop = paramInt2;
        this.mBottom = (aqcx.dip2px(getContext(), 20.0F) + paramInt3);
        this.mHeight = (paramInt3 - paramInt2);
        this.mCount = new AtomicInteger(0);
        al(this);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation run initCount = " + i + " mTexture = " + this.jdField_a_of_type_Anyv);
      }
      return;
      if ((i > 1) && (this.jdField_a_of_type_Anyv != null)) {
        al(this);
      }
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "rain animation run mLoopNum = " + this.aYa);
    }
    if (this.aYa >= aXY)
    {
      this.aYa = 0;
      return;
    }
    int i = 0;
    while (i < aXX)
    {
      anyu localanyu = new anyu(this);
      localanyu.a(this.jdField_a_of_type_Anyv);
      localanyu.scale = ((new Random().nextInt(2) * 2 + 8) / 10.0F);
      int j = this.mTop - new Random().nextInt(aqcx.dip2px(getContext(), aXW));
      int k = this.mBottom;
      int m = this.aXZ * i + new Random().nextInt(this.aXZ + 1);
      localanyu.setPosition(m, j);
      Object localObject = new anye(aXV, m, j, dz(m), k);
      localanyu.a(new anyb[] { localObject });
      ((anye)localObject).a(new ndf(this, localanyu));
      if (i == 0)
      {
        localObject = new anyc(DELAY_TIME);
        localanyu.a(new anyb[] { localObject });
        ((anyc)localObject).a(new ndg(this));
      }
      b(localanyu);
      i += 1;
    }
    this.aYa += 1;
  }
  
  public void setAnimationEndListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RainView
 * JD-Core Version:    0.7.0.1
 */