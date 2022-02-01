package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

public class QqViewFlipper
  extends ViewFlipper
{
  public QqViewFlipper(Context paramContext)
  {
    super(paramContext);
  }
  
  public QqViewFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      stopFlipping();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QqViewFlipper
 * JD-Core Version:    0.7.0.1
 */