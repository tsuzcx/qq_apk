package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import hwp;

public class Switch
  extends ToggleButton
{
  public Switch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772152);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnClickListener(new hwp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.Switch
 * JD-Core Version:    0.7.0.1
 */