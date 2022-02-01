package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;

public class MultiMembersAudioIndicator
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  public ViewPager mViewPager;
  
  public MultiMembersAudioIndicator(Context paramContext)
  {
    super(paramContext);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public MultiMembersAudioIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(0);
    super.setGravity(17);
  }
  
  public RadioButton a()
  {
    MultiMembersAudioIndicator.1 local1 = new MultiMembersAudioIndicator.1(this, super.getContext());
    local1.setButtonDrawable(2130843041);
    local1.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 10.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    local1.setLayoutParams(localLayoutParams);
    local1.setClickable(false);
    local1.setFocusable(false);
    return local1;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.mViewPager == null) {}
    RadioButton localRadioButton;
    do
    {
      do
      {
        return;
      } while ((this.mViewPager.getAdapter() == null) || (super.getChildCount() <= paramInt));
      int i = paramInt;
      if (paramInt >= super.getChildCount()) {
        i = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(i);
    } while (localRadioButton == null);
    localRadioButton.setChecked(true);
  }
  
  public void refreshIndicator()
  {
    if (this.mViewPager == null) {}
    do
    {
      return;
      localObject = this.mViewPager.getAdapter();
    } while (localObject == null);
    int k = ((PagerAdapter)localObject).getCount();
    super.removeAllViews();
    int i = 0;
    while (i < k)
    {
      super.addView(a());
      i += 1;
    }
    int j = this.mViewPager.getCurrentItem();
    i = j;
    if (j >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    Object localObject = (RadioButton)super.getChildAt(i);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(true);
    }
    if (k <= 1)
    {
      super.setVisibility(4);
      return;
    }
    super.setVisibility(0);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioIndicator
 * JD-Core Version:    0.7.0.1
 */