package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class RichTextPanelView
  extends RelativeLayout
{
  public RichTextPanelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextPanelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void Af(boolean paramBoolean) {}
  
  public String getName()
  {
    return "";
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanelView
 * JD-Core Version:    0.7.0.1
 */