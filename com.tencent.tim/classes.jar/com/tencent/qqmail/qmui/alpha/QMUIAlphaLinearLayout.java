package com.tencent.qqmail.qmui.alpha;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class QMUIAlphaLinearLayout
  extends LinearLayout
{
  public QMUIAlphaLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMUIAlphaLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMUIAlphaLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (Build.VERSION.SDK_INT > 11) {
      if ((!paramBoolean) || (!isEnabled())) {
        break label33;
      }
    }
    label33:
    for (float f = 0.5F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.alpha.QMUIAlphaLinearLayout
 * JD-Core Version:    0.7.0.1
 */