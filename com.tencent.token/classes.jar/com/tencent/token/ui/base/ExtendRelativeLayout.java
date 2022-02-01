package com.tencent.token.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ExtendRelativeLayout
  extends RelativeLayout
{
  private boolean a = true;
  
  public ExtendRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a)
    {
      paramInt3 = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt3)
      {
        View localView = getChildAt(paramInt1);
        if (localView.getVisibility() != 8)
        {
          int[] arrayOfInt = ((RelativeLayout.LayoutParams)localView.getLayoutParams()).getRules();
          if ((arrayOfInt[13] == 0) && (arrayOfInt[15] == 0)) {
            paramInt2 = 0;
          } else {
            paramInt2 = (getPaddingTop() - getPaddingBottom()) / 2;
          }
          if (paramInt2 != 0) {
            localView.offsetTopAndBottom(paramInt2);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void setLayoutConsiderPadding(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ExtendRelativeLayout
 * JD-Core Version:    0.7.0.1
 */