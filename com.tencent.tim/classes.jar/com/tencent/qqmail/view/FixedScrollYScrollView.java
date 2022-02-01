package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class FixedScrollYScrollView
  extends ScrollView
{
  private static final String TAG = "FixedScrollYScrollView";
  
  public FixedScrollYScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixedScrollYScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FixedScrollYScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public FixedScrollYScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getScrollY();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollTo(getScrollX(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FixedScrollYScrollView
 * JD-Core Version:    0.7.0.1
 */