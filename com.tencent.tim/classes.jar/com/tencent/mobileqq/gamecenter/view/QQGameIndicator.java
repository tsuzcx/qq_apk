package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.av.ui.MultiMembersAudioIndicator;

public class QQGameIndicator
  extends MultiMembersAudioIndicator
{
  private a a;
  
  public QQGameIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGameIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadioButton a()
  {
    QQGameIndicator.1 local1 = new QQGameIndicator.1(this, super.getContext());
    local1.setButtonDrawable(2130847120);
    local1.setGravity(17);
    Resources localResources = super.getContext().getResources();
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, 6.0F, localResources.getDisplayMetrics()));
    localLayoutParams.gravity = 17;
    int i = (int)TypedValue.applyDimension(1, 2.0F, localResources.getDisplayMetrics());
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    local1.setLayoutParams(localLayoutParams);
    local1.setClickable(false);
    local1.setFocusable(false);
    return local1;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.a != null) {
      this.a.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.mViewPager == null) {
      break label7;
    }
    label7:
    while ((this.mViewPager.getAdapter() == null) || (super.getChildCount() <= paramInt)) {
      return;
    }
    if (paramInt >= super.getChildCount()) {}
    for (int i = super.getChildCount() - 1;; i = paramInt)
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      if (this.a == null) {
        break;
      }
      this.a.onPageSelected(paramInt);
      return;
    }
  }
  
  public void setCurrentIndex(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= super.getChildCount()) {
      i = super.getChildCount() - 1;
    }
    RadioButton localRadioButton = (RadioButton)super.getChildAt(i);
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
  }
  
  public void setPageListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameIndicator
 * JD-Core Version:    0.7.0.1
 */