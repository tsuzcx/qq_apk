package com.tencent.mobileqq.activity.aio.audiopanel;

import acfp;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ViewPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public ViewPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (getChildCount() > paramInt)
    {
      RadioButton localRadioButton = (RadioButton)getChildAt(paramInt);
      if (localRadioButton != null)
      {
        localRadioButton.setChecked(true);
        if (paramInt == 1)
        {
          localRadioButton.setContentDescription(acfp.m(2131716496));
          localRadioButton.sendAccessibilityEvent(128);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ViewPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */