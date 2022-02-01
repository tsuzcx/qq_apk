package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aoop;
import argk;
import argl;
import argm;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

public class PaFlashLightView
  extends LinearLayout
{
  public a a = new a(this);
  Animation aX;
  Animation aY;
  Animation aZ;
  public URLImageView bW;
  public URLImageView bX;
  public URLImageView bY;
  public boolean daw;
  public int mIndex;
  
  public PaFlashLightView(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    setGravity(17);
    setOrientation(1);
    Drawable localDrawable = getResources().getDrawable(2131167595);
    this.bW = new URLImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    this.bW.setLayoutParams(localLayoutParams);
    try
    {
      paramString1 = aoop.getDrawable(paramString1, localDrawable, localDrawable);
      this.bW.setImageDrawable(paramString1);
      this.bW.setVisibility(8);
      addView(this.bW);
      this.bX = new URLImageView(paramContext);
      paramString1 = new LinearLayout.LayoutParams(-2, -2);
      paramString1.gravity = 1;
      this.bX.setLayoutParams(paramString1);
    }
    catch (Exception paramString1)
    {
      try
      {
        paramString1 = aoop.getDrawable(paramString2, localDrawable, localDrawable);
        this.bX.setImageDrawable(paramString1);
        this.bX.setVisibility(8);
        addView(this.bX);
        this.bY = new URLImageView(paramContext);
        paramContext = new LinearLayout.LayoutParams(-2, -2);
        paramContext.gravity = 5;
        this.bY.setLayoutParams(paramContext);
      }
      catch (Exception paramString1)
      {
        try
        {
          for (;;)
          {
            paramContext = aoop.getDrawable(paramString3, localDrawable, localDrawable);
            this.bY.setImageDrawable(paramContext);
            this.bY.setVisibility(8);
            addView(this.bY);
            this.aX = new AlphaAnimation(0.01F, 1.0F);
            this.aX.setDuration(150L);
            this.aX.setRepeatCount(0);
            this.aX.setAnimationListener(new argk(this));
            this.aY = new AlphaAnimation(0.01F, 1.0F);
            this.aY.setDuration(1150L);
            this.aY.setRepeatCount(0);
            this.aY.setAnimationListener(new argl(this));
            this.aZ = new AlphaAnimation(1.0F, 0.01F);
            this.aZ.setDuration(800L);
            this.aZ.setRepeatCount(0);
            this.aZ.setAnimationListener(new argm(this));
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          }
          paramString1 = paramString1;
          paramString1.printStackTrace();
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public static class a
    extends Handler
  {
    private WeakReference<PaFlashLightView> iG;
    
    public a(PaFlashLightView paramPaFlashLightView)
    {
      this.iG = new WeakReference(paramPaFlashLightView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (PaFlashLightView)this.iG.get();
      if (paramMessage == null) {
        return;
      }
      switch (paramMessage.mIndex)
      {
      default: 
        return;
      case 0: 
        paramMessage.bW.setVisibility(0);
        if (paramMessage.daw)
        {
          paramMessage.startAnimation(paramMessage.aX);
          return;
        }
        paramMessage.startAnimation(paramMessage.aZ);
        return;
      case 1: 
        paramMessage.bX.setVisibility(0);
        if (paramMessage.daw)
        {
          paramMessage.bX.startAnimation(paramMessage.aY);
          return;
        }
        paramMessage.bX.startAnimation(paramMessage.aZ);
        return;
      }
      paramMessage.bY.setVisibility(0);
      if (paramMessage.daw)
      {
        paramMessage.bY.startAnimation(paramMessage.aX);
        return;
      }
      paramMessage.bY.startAnimation(paramMessage.aZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaFlashLightView
 * JD-Core Version:    0.7.0.1
 */