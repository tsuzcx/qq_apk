package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Build;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import ram;

public class ThreeDTransformer
  implements ViewPager.PageTransformer
{
  boolean aDE = true;
  boolean aDF = false;
  boolean aDG = false;
  boolean aDH = "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  public int bmA;
  HashMap<Integer, Integer> fo = new HashMap();
  boolean mIsReset = true;
  float mi;
  
  public ThreeDTransformer(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aDF = paramBoolean1;
    this.aDG = paramBoolean2;
  }
  
  private void a(View paramView, float paramFloat, boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (this.aDE)
    {
      if (this.aDG)
      {
        if (paramBoolean) {
          f1 = paramView.getMeasuredWidth();
        }
        paramView.setPivotX(f1);
        paramView.setPivotY(paramView.getMeasuredHeight() * 0.5F);
        paramView.setRotationY(20.0F * paramFloat);
        return;
      }
      paramView.setRotationY(0.0F);
      return;
    }
    if (this.aDF)
    {
      f1 = f2;
      if (paramBoolean) {
        f1 = paramView.getMeasuredWidth();
      }
      paramView.setPivotX(f1);
      paramView.setPivotY(paramView.getMeasuredHeight() * 0.5F);
      paramView.setRotationY(20.0F * paramFloat);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void b(View paramView, float paramFloat, boolean paramBoolean)
  {
    float f2 = (float)(Math.sin((1.0F + paramFloat) * 3.141592653589793D) * 0.1599999964237213D);
    float f1 = (float)(Math.sin((1.0F - paramFloat) * 3.141592653589793D) * 0.1599999964237213D);
    f2 += 1.0F + paramFloat;
    paramFloat = f1 + (1.0F - paramFloat);
    if (this.aDE)
    {
      if (this.aDG)
      {
        if (paramBoolean)
        {
          paramView.setScaleX(f2);
          paramView.setTranslationX((1.0F - f2) * paramView.getMeasuredWidth() / 2.0F);
          return;
        }
        paramView.setScaleX(paramFloat);
        paramView.setTranslationX(paramView.getMeasuredWidth() * (paramFloat - 1.0F) / 2.0F);
        return;
      }
      paramView.setScaleX(1.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    if (this.aDF)
    {
      if (paramBoolean)
      {
        paramView.setScaleX(f2);
        paramView.setTranslationX((1.0F - f2) * paramView.getMeasuredWidth() / 2.0F);
        return;
      }
      paramView.setScaleX(paramFloat);
      paramView.setTranslationX(paramView.getMeasuredWidth() * (paramFloat - 1.0F) / 2.0F);
      return;
    }
    paramView.setScaleX(1.0F);
    paramView.setTranslationX(0.0F);
  }
  
  private void dK(View paramView)
  {
    if (this.aDH)
    {
      paramView.setScaleX(1.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    paramView.setRotationY(0.0F);
  }
  
  private void e(View paramView, float paramFloat)
  {
    int i;
    boolean bool;
    label144:
    StringBuilder localStringBuilder;
    if ((this.bmA == 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F))
    {
      i = paramView.hashCode();
      if (this.fo.get(Integer.valueOf(i)) == null)
      {
        this.fo.put(Integer.valueOf(i), Integer.valueOf(0));
        ram.d("ThreeDTransformer", "mInitMatcher viewId: " + i + " | count: " + 0);
      }
    }
    else if ((this.bmA != 0) && (paramFloat < 0.0F) && (paramFloat >= -1.0F) && (this.mIsReset))
    {
      if (paramFloat >= this.mi) {
        break label233;
      }
      bool = true;
      this.aDE = bool;
      if (!this.aDE) {
        break label239;
      }
      boD();
      this.mIsReset = false;
      localStringBuilder = new StringBuilder().append("initDrawingView direction: ");
      if (!this.aDE) {
        break label246;
      }
    }
    label233:
    label239:
    label246:
    for (paramView = "toLeft";; paramView = "toRight")
    {
      ram.d("ThreeDTransformer", paramView);
      return;
      this.bmA = i;
      this.mi = paramFloat;
      this.fo.clear();
      ram.d("ThreeDTransformer", "initDrawingView pos: " + this.bmA);
      return;
      bool = false;
      break;
      boE();
      break label144;
    }
  }
  
  private void f(View paramView, float paramFloat)
  {
    if (this.bmA == paramView.hashCode())
    {
      this.mi = paramFloat;
      if (QLog.isColorLevel()) {
        QLog.d("ThreeDTransformer", 2, "mlastPos: " + this.mi + " | mDragingViewID: " + this.bmA);
      }
      if ((paramFloat <= -1.0F) || (paramFloat >= 0.0F))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreeDTransformer", 2, "is OVER");
        }
        this.bmA = 0;
        this.mi = 0.0F;
        this.mIsReset = true;
      }
    }
  }
  
  protected void boD() {}
  
  protected void boE() {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    paramView.setAlpha(1.0F);
    paramView.setScaleX(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    if ((!this.aDF) && (!this.aDG))
    {
      dK(paramView);
      return;
    }
    e(paramView, paramFloat);
    if (this.bmA == 0)
    {
      dK(paramView);
      return;
    }
    if (paramFloat <= -1.0F) {
      dK(paramView);
    }
    for (;;)
    {
      f(paramView, paramFloat);
      return;
      if (paramFloat <= 0.0F)
      {
        if (this.aDH) {
          b(paramView, paramFloat, true);
        } else {
          a(paramView, paramFloat, true);
        }
      }
      else if (paramFloat < 1.0F)
      {
        if (this.aDH) {
          b(paramView, paramFloat, false);
        } else {
          a(paramView, paramFloat, false);
        }
      }
      else {
        dK(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.ThreeDTransformer
 * JD-Core Version:    0.7.0.1
 */