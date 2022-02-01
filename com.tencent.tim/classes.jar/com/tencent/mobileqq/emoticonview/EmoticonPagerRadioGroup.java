package com.tencent.mobileqq.emoticonview;

import afqr;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.common.config.AppSetting;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static int cSb = 1;
  private static int cSc = 2;
  private boolean bZg;
  private int cRY;
  private int cRZ = -1;
  private int cSa;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  RadioButton n = a(2);
  RadioButton o = a(3);
  RadioButton p = a(4);
  ViewPager viewPager;
  
  public EmoticonPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private RadioButton a(int paramInt)
  {
    float f1 = 13.0F;
    float f2 = 10.0F;
    EmoticonPagerRadioGroup.1 local1 = new EmoticonPagerRadioGroup.1(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      local1.setButtonDrawable(2130848002);
      local1.setGravity(17);
      localResources = super.getContext().getResources();
      if (paramInt != 2) {
        break label209;
      }
      f1 = 15.0F;
      f2 = 15.0F;
    }
    for (;;)
    {
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, f2, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      local1.setLayoutParams(localLayoutParams);
      local1.setClickable(true);
      if ((AppSetting.enableTalkBack) && (paramInt != 3) && (paramInt != 2))
      {
        local1.setClickable(false);
        local1.setFocusable(false);
      }
      return local1;
      if (paramInt == 3)
      {
        local1.setButtonDrawable(2130848003);
        break;
      }
      if (paramInt == 4)
      {
        local1.setButtonDrawable(2130838697);
        break;
      }
      local1.setButtonDrawable(2130840175);
      break;
      label209:
      if (paramInt == 3) {
        f1 = 24.0F;
      } else if (paramInt == 4) {
        f2 = 13.0F;
      } else {
        f1 = 10.0F;
      }
    }
  }
  
  public void MF(int paramInt)
  {
    bw(paramInt, false);
  }
  
  public void MG(int paramInt)
  {
    int j = 0;
    this.cRY = paramInt;
    if (!this.bZg)
    {
      removeAllViews();
      int k = afqr.cTs;
      int m = Math.max(afqr.cTs, paramInt);
      super.addView(this.o);
      int i = 0;
      while (i < m)
      {
        super.addView(a(1));
        i += 1;
      }
      super.addView(this.n);
      i = j;
      while (i < k + paramInt - m - 2)
      {
        RadioButton localRadioButton = a(1);
        localRadioButton.setVisibility(8);
        super.addView(localRadioButton);
        i += 1;
      }
    }
    this.bZg = true;
  }
  
  public void bw(int paramInt, boolean paramBoolean)
  {
    super.removeView(this.n);
    super.removeView(this.o);
    removeAllViews();
    if (paramBoolean) {
      super.addView(this.p);
    }
    this.cRZ = -1;
    int j = getChildCount();
    int i;
    if (paramInt > j)
    {
      i = 0;
      while (i < paramInt - j)
      {
        super.addView(a(1));
        i += 1;
      }
    }
    if (paramInt < j)
    {
      i = j - 1;
      while (i >= paramInt)
      {
        super.removeViewAt(i);
        i -= 1;
      }
    }
    if ((paramInt > 0) && (this.viewPager != null))
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(0);
      if (!paramBoolean) {
        localRadioButton.setButtonDrawable(2130840175);
      }
      localRadioButton = (RadioButton)super.getChildAt(this.viewPager.getCurrentItem());
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
    }
    paramInt = 0;
    while (paramInt < getChildCount())
    {
      ((RadioButton)super.getChildAt(paramInt)).setVisibility(0);
      paramInt += 1;
    }
    this.bZg = false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageSelected(paramInt);
    }
    int j;
    int k;
    int i;
    RadioButton localRadioButton;
    if (super.getChildCount() > paramInt)
    {
      if (!this.bZg) {
        break label372;
      }
      j = afqr.cTs;
      k = this.cRY;
      if (((this.cRZ != j) || (paramInt != j - 1)) && (paramInt != 0)) {
        break label232;
      }
      this.o.setVisibility(8);
      this.n.setVisibility(0);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      this.cSa = cSc;
      if (this.cSa != cSc) {
        break label363;
      }
      i = paramInt + 1;
      label188:
      this.cRZ = paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i >= super.getChildCount()) {
        paramInt = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(paramInt);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      return;
      label232:
      if ((paramInt != j) && (paramInt != j + k - 1)) {
        break;
      }
      this.o.setVisibility(0);
      this.n.setVisibility(8);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      this.cSa = cSb;
      break;
      label363:
      i = paramInt - (j - 1);
      break label188;
      label372:
      this.cRZ = -1;
      i = paramInt;
    }
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.viewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */