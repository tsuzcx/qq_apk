package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.CheckBox;

public class KeepPressedCheckBox
  extends CheckBox
{
  private final Runnable mCheckForChecked = new KeepPressedCheckBox.1(this);
  
  public KeepPressedCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public KeepPressedCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KeepPressedCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    super.dispatchSetPressed(paramBoolean);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.setPressed(false);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (!paramBoolean) {
      super.setPressed(false);
    }
    super.setChecked(paramBoolean);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setPressed(paramBoolean);
      return;
    }
    postDelayed(this.mCheckForChecked, ViewConfiguration.getLongPressTimeout());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.KeepPressedCheckBox
 * JD-Core Version:    0.7.0.1
 */