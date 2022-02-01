package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class EmoticonPageIndicator
  extends EmoticonPagerRadioGroup
{
  public EmoticonPageIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.viewPager = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPageIndicator
 * JD-Core Version:    0.7.0.1
 */