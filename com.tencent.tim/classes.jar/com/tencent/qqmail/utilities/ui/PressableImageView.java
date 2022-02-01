package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PressableImageView
  extends ImageView
{
  public PressableImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PressableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (Build.VERSION.SDK_INT > 11) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (float f = 0.6F;; f = 1.0F)
    {
      setAlpha(f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PressableImageView
 * JD-Core Version:    0.7.0.1
 */