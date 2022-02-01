package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import aris;

public class ObservableScrollView
  extends ScrollView
{
  private aris a;
  
  public ObservableScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ObservableScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setScrollViewListener(aris paramaris)
  {
    this.a = paramaris;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ObservableScrollView
 * JD-Core Version:    0.7.0.1
 */