package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class TopBehindLayout
  extends FrameLayout
{
  private View E;
  
  public TopBehindLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext) {}
  
  public void setContent(View paramView)
  {
    if (this.E != null) {
      removeView(this.E);
    }
    this.E = paramView;
    addView(this.E);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopBehindLayout
 * JD-Core Version:    0.7.0.1
 */