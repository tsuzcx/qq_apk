package com.tencent.viola.ui.animation;

import android.view.ViewGroup.LayoutParams;

public class WidthProperty
  extends LayoutParamsProperty
{
  protected Integer getProperty(ViewGroup.LayoutParams paramLayoutParams)
  {
    return Integer.valueOf(paramLayoutParams.width);
  }
  
  protected void setProperty(ViewGroup.LayoutParams paramLayoutParams, Integer paramInteger)
  {
    paramLayoutParams.width = paramInteger.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.animation.WidthProperty
 * JD-Core Version:    0.7.0.1
 */