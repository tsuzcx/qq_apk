package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class WheelTextView
  extends TextView
{
  public WheelTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(2, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != getPaint().getTextSize())
      {
        getPaint().setTextSize(paramFloat);
        if (getLayout() != null) {
          invalidate();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.WheelTextView
 * JD-Core Version:    0.7.0.1
 */