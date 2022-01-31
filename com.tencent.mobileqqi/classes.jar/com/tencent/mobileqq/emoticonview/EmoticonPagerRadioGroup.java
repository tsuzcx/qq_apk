package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import fot;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 3;
  private static int f = 1;
  private static int g = 2;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton = a(2);
  boolean jdField_a_of_type_Boolean;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton = a(3);
  private boolean jdField_b_of_type_Boolean;
  private int d = -1;
  private int e;
  
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
    float f1 = 15.0F;
    float f2 = 10.0F;
    fot localfot = new fot(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      localfot.setButtonDrawable(2130839152);
      localfot.setGravity(17);
      localResources = getContext().getResources();
      if (paramInt != 2) {
        break label185;
      }
      f2 = 15.0F;
    }
    for (;;)
    {
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, f2, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localfot.setLayoutParams(localLayoutParams);
      localfot.setClickable(true);
      if ((paramInt != 3) && (paramInt != 2))
      {
        localfot.setClickable(false);
        localfot.setFocusable(false);
      }
      return localfot;
      if (paramInt == 3)
      {
        localfot.setButtonDrawable(2130839155);
        break;
      }
      localfot.setButtonDrawable(2130837975);
      break;
      label185:
      if (paramInt == 3)
      {
        f2 = 24.0F;
        f1 = 10.0F;
      }
      else
      {
        f1 = 10.0F;
      }
    }
  }
  
  public ViewPager a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
  }
  
  public void a()
  {
    this.d = -1;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    int j;
    RadioButton localRadioButton;
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        removeAllViews();
        j = SystemAndEmojiEmoticonInfo.i;
        int k = SystemAndEmojiEmoticonInfo.h;
        int m = Math.max(SystemAndEmojiEmoticonInfo.i, SystemAndEmojiEmoticonInfo.h);
        addView(this.jdField_b_of_type_AndroidWidgetRadioButton);
        paramInt = 0;
        while (paramInt < m)
        {
          addView(a(1));
          paramInt += 1;
        }
        addView(this.jdField_a_of_type_AndroidWidgetRadioButton);
        paramInt = i;
        while (paramInt < k + j - m - 2)
        {
          localRadioButton = a(1);
          localRadioButton.setVisibility(8);
          addView(localRadioButton);
          paramInt += 1;
        }
      }
    }
    else
    {
      removeView(this.jdField_a_of_type_AndroidWidgetRadioButton);
      removeView(this.jdField_b_of_type_AndroidWidgetRadioButton);
      this.d = -1;
      j = getChildCount();
      if (paramInt > j)
      {
        i = 0;
        while (i < paramInt - j)
        {
          addView(a(1));
          i += 1;
        }
      }
      if (paramInt < j)
      {
        i = j - 1;
        while (i >= paramInt)
        {
          removeViewAt(i);
          i -= 1;
        }
      }
      if ((paramInt > 0) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
      {
        localRadioButton = (RadioButton)getChildAt(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label278;
        }
        localRadioButton.setButtonDrawable(2130837976);
      }
      for (;;)
      {
        localRadioButton.setChecked(true);
        paramInt = 0;
        while (paramInt < getChildCount())
        {
          ((RadioButton)getChildAt(paramInt)).setVisibility(0);
          paramInt += 1;
        }
        label278:
        localRadioButton.setButtonDrawable(2130837975);
      }
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j;
    int k;
    int i;
    RadioButton localRadioButton;
    if (getChildCount() > paramInt)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label358;
      }
      j = SystemAndEmojiEmoticonInfo.i;
      k = SystemAndEmojiEmoticonInfo.h;
      if ((this.d != j) || (paramInt != j - 1)) {
        break label210;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)getChildAt(i);
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
          localRadioButton = (RadioButton)getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      this.e = g;
      if (this.e != g) {
        break label349;
      }
      i = paramInt + 1;
      label166:
      this.d = paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i >= getChildCount()) {
        paramInt = getChildCount() - 1;
      }
      localRadioButton = (RadioButton)getChildAt(paramInt);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      return;
      label210:
      if (((this.d != j - 1) && (this.d != -1)) || (paramInt != j)) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetRadioButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)getChildAt(i);
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
          localRadioButton = (RadioButton)getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      this.e = f;
      break;
      label349:
      i = paramInt - (j - 1);
      break label166;
      label358:
      this.d = -1;
      i = paramInt;
    }
  }
  
  public void setRecent(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */