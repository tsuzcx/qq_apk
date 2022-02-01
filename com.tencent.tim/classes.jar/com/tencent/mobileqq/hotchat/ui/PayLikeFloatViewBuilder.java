package com.tencent.mobileqq.hotchat.ui;

import ahym;
import ahyo;
import ahyr;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.widget.TextView;
import aqhu;
import aquz;
import aqva;
import aqvc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class PayLikeFloatViewBuilder
  extends ahyo
{
  private static boolean cje;
  private Drawable[] f;
  
  public PayLikeFloatViewBuilder(Context paramContext, int paramInt, ahym paramahym)
  {
    super(paramContext, paramInt, paramahym);
  }
  
  private static Bitmap a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    aquz localaquz = null;
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.nearby/nearby_pay_zan_anim.png";
    if (new File(str).exists())
    {
      paramQQAppInterface = new BitmapFactory.Options();
      paramQQAppInterface.inDensity = 320;
      paramQQAppInterface.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    }
    do
    {
      try
      {
        paramContext = aqhu.d(str, paramQQAppInterface);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      paramContext = localaquz;
    } while (cje);
    cje = true;
    paramContext = new Bundle();
    localaquz = new aquz("https://pub.idqqimg.com/pc/misc/nearby_pay_zan_anim.png", new File(str + ".tmp"));
    localaquz.retryCount = 2;
    ((aqva)paramQQAppInterface.getManager(47)).a(1).a(localaquz, new ahyr(str), paramContext);
    return null;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    if (this.f == null)
    {
      paramQQAppInterface = a(this.mContext, paramQQAppInterface);
      if (paramQQAppInterface == null) {
        return null;
      }
      this.f = new Drawable[20];
      int j = paramQQAppInterface.getWidth();
      int k = paramQQAppInterface.getHeight() / 20;
      int i = 0;
      while (i < 20)
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramQQAppInterface, 0, i * k, j, k);
        this.f[i] = new BitmapDrawable(this.mContext.getResources(), localBitmap);
        i += 1;
      }
    }
    return this.f;
  }
  
  public Bitmap ax()
  {
    super.ax();
    if (this.fo == null) {}
    try
    {
      this.fo = BitmapFactory.decodeResource(this.mContext.getResources(), this.dct);
      return this.fo;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public static class AnimationView
    extends TextView
  {
    protected ahyo d;
    protected AnimationDrawable l;
    protected QQAppInterface mApp;
    
    public AnimationView(Context paramContext, QQAppInterface paramQQAppInterface, ahyo paramahyo)
    {
      super();
      super.setGravity(17);
      this.mApp = paramQQAppInterface;
      this.d = paramahyo;
      if (super.getVisibility() == 0) {
        setVisibility(0);
      }
    }
    
    public void setVisibility(int paramInt)
    {
      if (super.getVisibility() != paramInt) {
        super.setVisibility(paramInt);
      }
      if (paramInt == 0)
      {
        startAnimation();
        return;
      }
      stopAnimation();
    }
    
    public void startAnimation()
    {
      if ((this.l == null) || (this.l.getNumberOfFrames() != 20))
      {
        this.l = new AnimationDrawable();
        Drawable[] arrayOfDrawable = this.d.a(this.mApp);
        if (arrayOfDrawable == null) {
          return;
        }
        int i = 0;
        while (i < 20)
        {
          this.l.addFrame(arrayOfDrawable[i], 50);
          i += 1;
        }
        this.l.setOneShot(false);
        super.setCompoundDrawablesWithIntrinsicBounds(null, this.l, null, null);
      }
      this.l.start();
    }
    
    public void stopAnimation()
    {
      super.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if (this.l != null)
      {
        this.l.stop();
        int i = 0;
        while (i < this.l.getNumberOfFrames())
        {
          Drawable localDrawable = this.l.getFrame(i);
          if (localDrawable != null) {
            localDrawable.setCallback(null);
          }
          i += 1;
        }
        this.l.setCallback(null);
        this.l = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */