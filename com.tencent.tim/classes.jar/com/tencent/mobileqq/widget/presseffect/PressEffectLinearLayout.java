package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import arko;

public class PressEffectLinearLayout
  extends LinearLayout
{
  private boolean avx;
  
  public PressEffectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (this.avx)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      arko.iH(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      arko.iI(this);
    }
  }
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.avx = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout
 * JD-Core Version:    0.7.0.1
 */