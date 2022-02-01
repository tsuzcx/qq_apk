package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;

public class OptionAbleEditText
  extends ConfigClearableEditText
{
  public OptionAbleEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public OptionAbleEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OptionAbleEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected String CP()
  {
    return "com.tencent.mobileqq.widget.OptionAbleEditText";
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    return super.onTextContextMenuItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OptionAbleEditText
 * JD-Core Version:    0.7.0.1
 */